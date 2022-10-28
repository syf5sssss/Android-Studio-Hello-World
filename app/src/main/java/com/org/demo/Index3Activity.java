package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.org.demo.navigation.ui.BottomNavigation1Activity;
import com.org.demo.navigation.ui.BottomNavigation2Activity;
import com.org.demo.navigation.ui.BottomNavigation3Activity;
import com.org.demo.slide.SlideActivity;
import com.org.helloworld.R;

public class Index3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index3);

        //底部导航栏1
        findViewById(R.id.BottomNavigation1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index3Activity.this, BottomNavigation1Activity.class));
            }
        });
        //底部导航栏2
        findViewById(R.id.BottomNavigation2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index3Activity.this, BottomNavigation2Activity.class));
            }
        });
        //底部导航栏3
        findViewById(R.id.BottomNavigation3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index3Activity.this, BottomNavigation3Activity.class));
            }
        });

        //拨打电话
        findViewById(R.id.CallPhone1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index3Activity.this, CallPhoneActivity.class));
            }
        });

        //左滑效果
        findViewById(R.id.SlideDemoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index3Activity.this, SlideActivity.class));
            }
        });









        //上一页
        findViewById(R.id.LastPage3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index3Activity.this, BActivity.class));
            }
        });
        //下一页
        findViewById(R.id.NextPage3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Index3Activity.this, BActivity.class));
            }
        });


    }
}