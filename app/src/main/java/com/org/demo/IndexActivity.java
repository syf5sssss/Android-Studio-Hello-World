package com.org.demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.org.helloworld.R;

/**
 * 首页
 */
public class IndexActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        //按钮
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, ButtonActivity.class));
            }
        });

        //文本框
        findViewById(R.id.textview1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, TextViewActivity.class));
            }
        });

        //输入框
        findViewById(R.id.edittext1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, EditTextActivity.class));
            }
        });
        //图片
        findViewById(R.id.image1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, ImageActivity.class));
            }
        });
        //单选框
        findViewById(R.id.radio1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, RadioActivity.class));
            }
        });
        //开关
        findViewById(R.id.switch1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, SwitchActivity.class));
            }
        });
        //进度条
        findViewById(R.id.progressbar1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, ProgressbBarActivity.class));
            }
        });
        //拖动条
        findViewById(R.id.seekbar1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, SeekBarActivity.class));
            }
        });
        //滚动条
        findViewById(R.id.scrollview1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, ScrollViewActivity.class));
            }
        });
        //时间日期
        findViewById(R.id.datetime1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, DateTimeActivity.class));
            }
        });
        //简单列表
        findViewById(R.id.listview1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, ListViewActivity.class));
            }
        });
        //多风格列表
        findViewById(R.id.listview3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, ListViewStyleActivity.class));
            }
        });
        //网格视图
        findViewById(R.id.gridview1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, GridViewActivity.class));
            }
        });
        //网格视图（图标）
        findViewById(R.id.gridview3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, GridView3Activity.class));
            }
        });
        //可折叠列表（下拉框）
        findViewById(R.id.listview2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, SpinnerActivity.class));
            }
        });
        //吐司
        findViewById(R.id.toast1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, ToastActivity.class));
            }
        });
        //对话框
        findViewById(R.id.alertdailog1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, AlertDailogActivity.class));
            }
        });
        //悬浮框
        findViewById(R.id.PopupWindow1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, PopupWindowActivity.class));
            }
        });
        //网页
        findViewById(R.id.WebView1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, WebViewActivity.class));
            }
        });
        //多选框
        findViewById(R.id.CheckBox1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, CheckBoxActivity.class));
            }
        });
        //计时器
        findViewById(R.id.ChronoMeter1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, ChronoMeter1Activity.class));
            }
        });
        //可扩展列表
        findViewById(R.id.MExpandableList1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, MExpandableList1Activity.class));
            }
        });
        //时钟
        findViewById(R.id.TextClock1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, TextClock1Activity.class));
            }
        });
        //Drawable
        findViewById(R.id.Drawable1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, DrawableActivity.class));
            }
        });

        //下一页
        findViewById(R.id.NextPage1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IndexActivity.this, BActivity.class));
            }
        });

    }
}
