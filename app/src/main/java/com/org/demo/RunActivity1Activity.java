package com.org.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.org.helloworld.R;

public class RunActivity1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onCreate() ===");
        setContentView(R.layout.activity_run_activity1);
        Button btn = findViewById(R.id.runbtn1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显示启动
                Intent in = new Intent(RunActivity1Activity.this, SecondActivity.class);
                startActivity(in);
            }
        });

        Button btn2 = findViewById(R.id.runbtn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //隐式启动
                Intent in = new Intent("com.org.demo.SecondActivity");
                startActivity(in);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("tag", "requestCode =" + requestCode);
        Log.e("tag", "resultCode =" + resultCode);
        Log.e("tag", "data =" + data.getStringExtra("back"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onStart() ===");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onResume() ===");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onPause() ===");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onStop() ===");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onRestart() ===");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ttit", "执行生命周期函数:=== FirstActivity onDestroy() ===");
    }
}