package com.org.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ServiceStart1 extends Service {
    private final String TAG = "service";

    //必须要实现的方法
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind方法被调用!");
        ServiceStart1Activity.stv = ServiceStart1Activity.stv + "onBind方法被调用!  \n";
        ServiceStart1Activity.tv.setText(ServiceStart1Activity.stv);
        return null;
    }

    //Service被创建时调用
    @Override
    public void onCreate() {
        Log.e(TAG, "onCreate方法被调用!");
        ServiceStart1Activity.stv = ServiceStart1Activity.stv + "onCreate方法被调用!  \n";
        ServiceStart1Activity.tv.setText(ServiceStart1Activity.stv);
        super.onCreate();
    }

    //Service被启动时调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand方法被调用!");
        Log.e(TAG, "flags:"+flags+"  startId:"+startId);
        ServiceStart1Activity.stv = ServiceStart1Activity.stv + "onStartCommand方法被调用!  \n";
        ServiceStart1Activity.tv.setText(ServiceStart1Activity.stv);
        return super.onStartCommand(intent, flags, startId);
    }

    //Service被关闭之前回调,可以多次销毁,不会报错
    @Override
    public void onDestroy() {
        Log.e(TAG, "onDestory方法被调用!");
        ServiceStart1Activity.stv = ServiceStart1Activity.stv + "onDestory方法被调用!  \n";
        ServiceStart1Activity.tv.setText(ServiceStart1Activity.stv);
        super.onDestroy();
    }
}
