package com.example.jiangweihao.sport.coding.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * Created by qingweiliu on 2018/3/31.
 */

public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        getIntent();
        initView();
        initData();
    }

    protected void getIntent(Bundle bundle){

    }
    protected void initData() {
    }

    public boolean isHasBus() {
        return false;
    }

    protected abstract int getLayoutId();

    protected void initView() {

    }

    @Override
    public void onBackPressed() {

    }

    protected boolean onInterceptBackPressed() {
        return false;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1.0F) {
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }

        return res;
    }



    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

}
