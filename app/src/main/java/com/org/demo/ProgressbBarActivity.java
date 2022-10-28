package com.org.demo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;

import com.org.helloworld.R;

public class ProgressbBarActivity extends AppCompatActivity {

    private int currentProgress = 0;//当前进度值
    private ProgressBar progressBar;
    private int maxProgress; //最大进度值

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    progressBar.setProgress(currentProgress);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressb_bar);
        progressBar = findViewById(R.id.pb);
        maxProgress = progressBar.getMax();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 启动线程模拟加载
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(1000);
                            currentProgress += 10;
                            if (currentProgress > maxProgress) {
                                break;
                            }
                            mHandler.sendEmptyMessage(0);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}