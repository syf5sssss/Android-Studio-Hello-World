package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.org.helloworld.R;

public class BackStackImg1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_stack_img1);

        Intent in = getIntent();
        String val = in.getStringExtra("Name");
        ImageView iv = (ImageView)findViewById(R.id.bsi1);
        if(val!=null && val.equals("Standard"))
        {
            Log.e("xx","Standard");
            iv.setImageResource(R.mipmap.standard);
        }
        if(val!=null && val.equals("SingleTop"))
        {
            Log.e("xx","SingleTop");
            iv.setImageResource(R.mipmap.singletop);
        }
        if(val!=null && val.equals("SingleTask"))
        {
            Log.e("xx","SingleTask");
            iv.setImageResource(R.mipmap.singletask);
        }
        if(val!=null && val.equals("SingleInstance"))
        {
            Log.e("xx","SingleInstance");
            iv.setImageResource(R.mipmap.singleinstance);
        }

    }





}