package com.crf.frame.base;

import android.arch.lifecycle.AndroidViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.crf.frame.R;

/**
 * @author crfmoon
 * @description
 * @date 2019-05-09 14:37
 */
public abstract class BaseActivity<VM extends AndroidViewModel, VB extends ViewDataBinding> extends AppCompatActivity {
    protected VM viewModel = null;
    protected VB bindingView = null;

    private View loadingView = null;
    private View errorView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        DataBindingUtil.setContentView(this, R.layout.activity_base);
    }
}
