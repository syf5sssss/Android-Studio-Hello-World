package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.org.demo.BroadCast.StaticBRReceiver;
import com.org.helloworld.R;

public class BroadCast2Activity extends AppCompatActivity {

    Button bn;
    public static TextView tv;
    public static String str = "";
    public static BroadCast2Activity bc2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast2);

        bc2= this;
        bn = findViewById(R.id.SendST1);
        tv = findViewById(R.id.ST2Text1);

        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //发送广播
//                Intent intent = new Intent("com.example.broadcasttest.StaticBRReceiver");
//                Android8.0以上系统不再支持该种方式
                Intent intent = new Intent();
                intent.putExtra("Name","睡觉了");
                intent.setComponent(new ComponentName(BroadCast2Activity.this, StaticBRReceiver.class));
                sendBroadcast(intent);

                str = str +"发送一条广播 睡觉了 \n";
                AddMessage(str);
            }
        });

    }

    /**
     * 添加信息
     */
    public static void AddMessage(final String s)
    {
        BroadCast2Activity.bc2.runOnUiThread(new Runnable() {
            public void run() {
                if(BroadCast2Activity.tv != null)
                {
                    BroadCast2Activity.tv.setText(s);
                }
                Log.e("T",s);
            }
        });
    }


}