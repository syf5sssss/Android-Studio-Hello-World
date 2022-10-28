package com.org.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class ServiceBind2 extends Service {
    private final String TAG = "service";
    private int count;
    private boolean quit;

    //定义onBinder方法所返回的对象
    private MyBinder binder = new MyBinder();

    public class MyBinder extends Binder {
        public int getCount() {
            return count;
        }
    }

    //必须实现的方法,绑定改Service时回调该方法
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind方法被调用!");
        ServiceBind2Activity.tvs = ServiceBind2Activity.tvs + " onBind方法被调用! \n";
        ServiceBind2Activity.tv.setText(ServiceBind2Activity.tvs);
        return binder;
    }

    //Service被创建时回调
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate方法被调用!");
        ServiceBind2Activity.tvs = ServiceBind2Activity.tvs + " onCreate方法被调用! \n";
        ServiceBind2Activity.tv.setText(ServiceBind2Activity.tvs);
        //创建一个线程动态地修改count的值
        new Thread() {
            public void run() {
                while (!quit) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    Log.e(TAG, "count = " + count);
                    ServiceBind2Activity.tvs = ServiceBind2Activity.tvs + " count = "+count+" \n";
                    ServiceBind2Activity.sb2.runOnUiThread(new Runnable() {
                        public void run() {
                            ServiceBind2Activity.tv.setText(ServiceBind2Activity.tvs);
                        }
                    });

                }
            }
        }.start();
    }

    //Service断开连接时回调,解绑时只能解绑一次,否则会报错
    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind方法被调用!");
        ServiceBind2Activity.tvs = ServiceBind2Activity.tvs + " onUnbind方法被调用! \n";
        ServiceBind2Activity.tv.setText(ServiceBind2Activity.tvs);
        return true;
    }

    //Service被关闭前回调
    @Override
    public void onDestroy() {
        super.onDestroy();
        this.quit = true;
        Log.e(TAG, "onDestroyed方法被调用!");
        ServiceBind2Activity.tvs = ServiceBind2Activity.tvs + " onDestroyed方法被调用! \n";
        ServiceBind2Activity.tv.setText(ServiceBind2Activity.tvs);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "onRebind方法被调用!");
        ServiceBind2Activity.tvs = ServiceBind2Activity.tvs + " onRebind方法被调用! \n";
        ServiceBind2Activity.tv.setText(ServiceBind2Activity.tvs);
        super.onRebind(intent);
    }
}
