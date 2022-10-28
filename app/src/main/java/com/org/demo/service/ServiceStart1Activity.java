package com.org.demo.service;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.org.helloworld.R;

public class ServiceStart1Activity extends AppCompatActivity {
    private Button start;
    private Button stop;
    public static TextView tv;
    public static String stv = "";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        start = (Button) findViewById(R.id.btnstart);
        stop = (Button) findViewById(R.id.btnstop);
        tv = (TextView) findViewById(R.id.ServiceStartText1);

        intent = new Intent(ServiceStart1Activity.this, ServiceStart1.class);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            stopService(intent);
        } catch (Exception e) {
            Log.e("TAG", "服务已经停止,无需再次停止!");
            ServiceStart1Activity.stv = ServiceStart1Activity.stv + "服务已经停止,无需再次停止!  \n";
            tv.setText(ServiceStart1Activity.stv);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            e.printStackTrace();
        }
        stv = "";
    }
}
