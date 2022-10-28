package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.org.demo.BroadCast.DynamicBRReceiver;
import com.org.helloworld.R;

public class BroadCast1Activity extends AppCompatActivity {

    private DynamicBRReceiver dynamicBRReceiver;

    Button bn;
    public static TextView tv;
    public static String str = "";
    public static BroadCast1Activity bc1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast1);
        bc1= this;
        bn = findViewById(R.id.SendDC1);
        tv = findViewById(R.id.DC1Text1);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.org.demo.BroadCast.DynamicBRReceiver");
                intent.putExtra("Name","吃饭了");
                sendBroadcast(intent);

//                Intent intent = new Intent();
//                intent.putExtra("Name","吃饭了");
//                intent.setComponent(new ComponentName(BroadCast1Activity.this, DynamicBRReceiver.class));
//                sendBroadcast(intent);
                str = str +"发送一条广播 吃饭了 \n";
                AddMessage(str);
            }
        });

        // 动态注册广播接收器
        dynamicBRReceiver = new DynamicBRReceiver();
        IntentFilter itFilter = new IntentFilter();
        itFilter.addAction("com.org.demo.BroadCast.DynamicBRReceiver");
        registerReceiver(dynamicBRReceiver, itFilter);
        str = str +"DynamicBRReceiver 注册成功 \n";
        AddMessage(str);
    }

    /**
     * 添加信息
     */
    public static void AddMessage(final String s)
    {
            BroadCast1Activity.bc1.runOnUiThread(new Runnable() {
            public void run() {
                if(BroadCast1Activity.tv != null)
                {
                    BroadCast1Activity.tv.setText(s);
                }
                Log.e("T",s);
            }
        });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicBRReceiver);
        str = "";
    }

}