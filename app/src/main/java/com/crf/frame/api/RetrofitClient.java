package com.crf.frame.api;


import com.softgarden.baselibrary.utils.L;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author crfmoon
 * @version 1.0
 * @description
 * @date 2019-05-07 16:00
 */
public class RetrofitClient {

    public volatile static Retrofit retrofit = null;

    public static Retrofit getInstance() {
        if (retrofit == null)
            synchronized (RetrofitClient.class) {
                if (retrofit == null) {
                    retrofit = getRetrofit();
                }
            }
        return retrofit;
    }

    public static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                //设置超时
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                //错误重连
                .retryOnConnectionFailure(true)
                //需要对请求参数进行处理的时候添加
                //   .addInterceptor(new ParameterInterceptor())// 拦截器
                .addInterceptor(loggingInterceptor);

        return builder.build();
    }

    public static HttpLoggingInterceptor loggingInterceptor =
            new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    //打印retrofit日志
                    L.w("RetrofitLog", message + "");
                }
            }).setLevel(HttpLoggingInterceptor.Level.BODY);


    public static Retrofit getRetrofit() {
        return new Retrofit.Builder().baseUrl(HostUrl.HOST_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();
    }

    public static <T> T getAPIService(Class<T> service) {
        return getInstance().create(service);
    }

    public static TestService getTestService() {
        return getAPIService(TestService.class);
    }

}
