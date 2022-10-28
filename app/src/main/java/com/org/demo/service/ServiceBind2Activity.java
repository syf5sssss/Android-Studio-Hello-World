package com.org.demo.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.org.helloworld.R;

public class ServiceBind2Activity extends AppCompatActivity {

    public static ServiceBind2Activity sb2;
    private Button btnbind;
    private Button btncancel;
    private Button btnstatus;
    public static TextView tv;
    public static String tvs = "";
    //保持所启动的Service的IBinder对象,同时定义一个ServiceConnection对象
    private ServiceBind2.MyBinder binder;

    private ServiceConnection conn = new ServiceConnection() {

        //Activity与Service断开连接时回调该方法
        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("service", " ------Service DisConnected-------");
            tvs = tvs +" ------Activity DisConnected 断开连接 ------- \n";
            tv.setText(tvs);
        }

        //Activity与Service连接成功时回调该方法
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("service", " ------Service Connected------ - ");
            tvs = tvs +" ------Activity Connected 连接成功 ------- \n";
            tv.setText(tvs);
            binder = (ServiceBind2.MyBinder) service;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service2);
        sb2 = this;
        btnbind = (Button) findViewById(R.id.btnbind);
        btncancel = (Button) findViewById(R.id.btncancel);
        btnstatus = (Button) findViewById(R.id.btnstatus);
        tv = (TextView) findViewById(R.id.ServiceBindText1);

        final Intent intent = new Intent(ServiceBind2Activity.this, ServiceBind2.class);

        btnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //绑定service
                bindService(intent, conn, Service.BIND_AUTO_CREATE);
            }
        });

        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //解除service绑定
                unbindService(conn);
            }
        });

        btnstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Service的count的值为:"
                        + binder.getCount(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        try {
            unbindService(conn); // 销毁Activity时需要解绑Service
            Log.e("service", " ------ServiceBind2Activity unbindService OK ------ - ");
            tvs = tvs +" ------ Activity unbindService OK ------- \n";
            tv.setText(tvs);
        } catch (Exception e) {
            Log.e("service", " ------服务已经解绑，无需再次解绑 ------ - ");
            tvs = tvs +" ------服务已经解绑，无需再次解绑 ------- \n";
            tv.setText(tvs);
//            Log.e("service", ""+e.getMessage()+"");
            e.printStackTrace();
        }
        Log.e("service", " ------ ServiceBind2Activity onDestroy End ------ - ");
        tvs = tvs +" ------Activity onDestroy End ------- \n";
        tv.setText(tvs);
        tvs = "";
    }
}
