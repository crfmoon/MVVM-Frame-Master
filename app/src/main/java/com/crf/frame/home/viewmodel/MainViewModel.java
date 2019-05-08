package com.crf.frame.home.viewmodel;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;

import com.crf.frame.R;
import com.crf.frame.home.contract.FragmentController;

/**
 * @author crfmoon
 * @description
 * @date 2019-05-08 09:40
 */
public class MainViewModel {
    private Context context = null;

    public MainViewModel(Context context) {
        this.context = context;
        showTabs(0);
    }


    public RadioGroup.OnCheckedChangeListener onCheckedChanged() {
        return new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.home_tab1:
                        showTabs(0);
                        break;
                    case R.id.home_tab2:
                        showTabs(1);
                        break;
                    case R.id.home_tab3:
                        showTabs(2);
                        break;
                    case R.id.home_tab4:
                        showTabs(3);
                        break;
                    default:
                        break;
                }
            }
        };
    }

    private void showTabs(int index) {
        FragmentController mController = FragmentController.getInstance((FragmentActivity) context, R.id.fl_content, true);
        mController.showFragment(index);
    }

    public void onDestroy() {
        FragmentController.onDestroy();
    }
}
