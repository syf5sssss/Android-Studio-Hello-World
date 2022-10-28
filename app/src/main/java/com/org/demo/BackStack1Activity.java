package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.org.helloworld.R;

public class BackStack1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_stack1);

        findViewById(R.id.bs1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BackStack1Activity.this, BackStackImg1Activity.class);
                in.putExtra("Name","Standard");
                startActivity(in);
            }
        });
        findViewById(R.id.bs2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BackStack1Activity.this, BackStackImg1Activity.class);
                in.putExtra("Name","SingleTop");
                startActivity(in);
            }
        });
        findViewById(R.id.bs3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BackStack1Activity.this, BackStackImg1Activity.class);
                in.putExtra("Name","SingleTask");
                startActivity(in);
            }
        });
        findViewById(R.id.bs4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(BackStack1Activity.this, BackStackImg1Activity.class);
                in.putExtra("Name","SingleInstance");
                startActivity(in);
            }
        });


    }
}