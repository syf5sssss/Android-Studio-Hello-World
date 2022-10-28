package com.org.demo.handler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.org.helloworld.R;

import java.util.Timer;
import java.util.TimerTask;


public class HandlerActivity extends AppCompatActivity {
    private int num = 0;
    private int num2 = 0;
    private TextView tv;
    private TextView tv2;
    private WorkThread workThread = null;

    private Handler myHandler = new Handler() {
        @Override
        //重写handleMessage方法,根据msg中what的值判断是否执行后续操作
        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                num++;
                tv.setText(String.valueOf(num));
            }
        }
    };



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        tv = findViewById(R.id.tv_handler_content);
        tv2 = findViewById(R.id.tv_thread_content);
        findViewById(R.id.btn_handler_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        myHandler.sendEmptyMessage(0);
                    }
                }, 0, 1000);
                findViewById(R.id.btn_handler_send).setEnabled(false);
            }
        });

        findViewById(R.id.btn_thread_send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 启动新线程
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        num2++;
                        HandlerActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv2.setText(String.valueOf(num2));
                            }
                        });
//                        workThread.mHandler.sendEmptyMessage(1);
                    }
                }, 0, 1000);
                Log.e("org","start thread HandlerActivity");
//                workThread = new HandlerActivity.WorkThread();
//                workThread.start();
                findViewById(R.id.btn_thread_send).setEnabled(false);
            }
        });


    }

    @Override
    protected void onDestroy() {
        num = 0;
        num2 = 0;
        super.onDestroy();
    }

    class WorkThread extends Thread {
        public Handler mHandler;

        public void run() {
            Looper.prepare();
            mHandler = new Handler() {
                // 定义处理消息的方法
                @Override
                public void handleMessage(Message msg) {
                    if (msg.what == 1) {
                        num++;
                        HandlerActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv2.setText(String.valueOf(num));
                            }
                        });
                    }
                }
            };
            Looper.loop();
        }
    }

}
