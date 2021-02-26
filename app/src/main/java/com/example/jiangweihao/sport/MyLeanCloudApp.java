package com.example.jiangweihao.sport;

import android.app.Application;

import com.avos.avoscloud.AVOSCloud;
import com.example.jiangweihao.sport.coding.utils.SPUtils;

public class MyLeanCloudApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SPUtils.INSTANCE.init(this);
        SPUtils.INSTANCE.putBoolean("first",true);
        // 初始化参数依次为 this, AppId, AppKey
        AVOSCloud.initialize(this,"uG2yfwPzHHx66jBaEsLGMpWA-gzGzoHsz","KiAxg1lscQhWgtRScxeK0s9E");
    }
}
