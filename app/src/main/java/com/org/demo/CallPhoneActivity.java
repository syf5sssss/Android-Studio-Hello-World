package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.org.h5.JsCallJavaCallPhoneActivity;
import com.org.helloworld.R;

public class CallPhoneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_phone);

        Button bt = findViewById(R.id.CallPhoneButton1);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "8848"));
                    startActivity(intent);
                    Log.e("org","start 拨打电话 Activity");
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(CallPhoneActivity.this, "还需要确认应用授予权限", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}