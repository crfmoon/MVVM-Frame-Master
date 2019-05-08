package com.crf.frame;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.crf.frame.databinding.ActivityMainBinding;
import com.crf.frame.home.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding = null;
    private MainViewModel mainViewModel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this);
        binding.setViewmodel(mainViewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainViewModel.onDestroy();
    }
}
