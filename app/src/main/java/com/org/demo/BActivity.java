package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.org.demo.handler.HandlerActivity;
import com.org.demo.http.JsonAcitivity;
import com.org.demo.http.OkhttpActivity;
import com.org.demo.Fragment.FragActivity;
import com.org.demo.dispatch.DispatchActivity;
import com.org.demo.provider.ContentProviderActivity;
import com.org.demo.service.ServiceBind2Activity;
import com.org.demo.service.ServiceStart1Activity;
import com.org.h5.DemoH5Activity;
import com.org.helloworld.R;

public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index2);

        //上一页
        findViewById(R.id.LastPage2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, IndexActivity.class));
            }
        });
        //下一页
        findViewById(R.id.NextPage2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, Index3Activity.class));
            }
        });
        //线性布局
        findViewById(R.id.linearLayOut1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, LinearLayout1Activity.class));
            }
        });
        //相对布局
        findViewById(R.id.RelativeLayout1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, RelativeLayout1Activity.class));
            }
        });
        //帧布局
        findViewById(R.id.FrameLayout1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, FrameLayout1Activity.class));
            }
        });
        //网格布局
        findViewById(R.id.GridLayout1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, GridLayout1Activity.class));
            }
        });
        //适配器
        findViewById(R.id.Adapter1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, Adapter1Activity.class));
            }
        });
        //分发事件
        findViewById(R.id.Dispatch1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, DispatchActivity.class));
            }
        });
        //启动方式 Activity
        findViewById(R.id.RunActivity1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, RunActivity1Activity.class));
            }
        });
        //Activity 组件通讯
        findViewById(R.id.CommunicationActivity1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, Communication1Activity.class));
            }
        });
        //Activity 生命周期
        findViewById(R.id.LifeCycle1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, LifeCycle1Activity.class));
            }
        });
        //Activity 回退堆栈
        findViewById(R.id.BackStack1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, BackStack1Activity.class));
            }
        });
        //Service Start
        findViewById(R.id.ServiceStart1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, ServiceStart1Activity.class));
            }
        });
        //Service Bind
        findViewById(R.id.ServiceBind1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, ServiceBind2Activity.class));
            }
        });
        //线程
        findViewById(R.id.Thread1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, Thread1Activity.class));
            }
        });
        //动态广播
        findViewById(R.id.BroadCast1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, BroadCast1Activity.class));
            }
        });
        //静态广播
        findViewById(R.id.BroadCast2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, BroadCast2Activity.class));
            }
        });
        //内容提供者
        findViewById(R.id.ContentProvider1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, ContentProviderActivity.class));
            }
        });
        //碎片
        findViewById(R.id.Fragment1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, FragActivity.class));
            }
        });
        //轻量级存储
        findViewById(R.id.Shared_Preferences1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, SharedPreferences1Activity.class));
            }
        });
        //SqlLite
        findViewById(R.id.SqlLite1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, SqlLite1Activity.class));
            }
        });
        //HTTP网络请求
        findViewById(R.id.HttpQuestion1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, OkhttpActivity.class));
            }
        });
        //Handler消息传递
        findViewById(R.id.Handler1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, HandlerActivity.class));
            }
        });
        //Json解析
        findViewById(R.id.Json1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, JsonAcitivity.class));
            }
        });
        //简单页面展示
        findViewById(R.id.DemoIndex1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, IndexDemoActivity.class));
            }
        });
        //H5交互页面
        findViewById(R.id.H5Demo1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, DemoH5Activity.class));
            }
        });



    }
}