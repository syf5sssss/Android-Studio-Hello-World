package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.org.helloworld.R;

public class LifeCycle1Activity extends AppCompatActivity {

    public static String res = "";
    public static Button btn;
    public static TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle1);
        Log.e("ttit", "执行生命周期函数: LifeCycle1Activity onCreate() ===");

        btn = findViewById(R.id.OpenView9);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(LifeCycle1Activity.this, DailogShow1Activity.class);
                startActivity(in);
            }
        });
        res = res +"执行生命周期函数: LifeCycle1Activity onCreate() \n";
        tv1 = (TextView) findViewById(R.id.LeftCycleText1);
        tv1.setText(LifeCycle1Activity.res);

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ttit", "执行生命周期函数: LifeCycle1Activity onStart() ===");
        res = res +"执行生命周期函数: LifeCycle1Activity onStart() \n";
        tv1 = (TextView) findViewById(R.id.LeftCycleText1);
        tv1.setText(LifeCycle1Activity.res);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ttit", "执行生命周期函数: LifeCycle1Activity onResume() ===");
        res = res +"执行生命周期函数: LifeCycle1Activity onResume() \n";
        tv1 = (TextView) findViewById(R.id.LeftCycleText1);
        tv1.setText(LifeCycle1Activity.res);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ttit", "执行生命周期函数: LifeCycle1Activity onPause() ===");
        res = res +"执行生命周期函数: LifeCycle1Activity onPause() \n";
        tv1 = (TextView) findViewById(R.id.LeftCycleText1);
        tv1.setText(LifeCycle1Activity.res);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ttit", "执行生命周期函数: LifeCycle1Activity onStop() ===");
        res = res +"执行生命周期函数: LifeCycle1Activity onStop() \n";
        tv1 = (TextView) findViewById(R.id.LeftCycleText1);
        tv1.setText(LifeCycle1Activity.res);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("ttit", "执行生命周期函数: LifeCycle1Activity onRestart() ===");
        res = res +"执行生命周期函数: LifeCycle1Activity onRestart() \n";
        tv1 = (TextView) findViewById(R.id.LeftCycleText1);
        tv1.setText(LifeCycle1Activity.res);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ttit", "执行生命周期函数: LifeCycle1Activity onDestroy() ===");
        res = res +"执行生命周期函数: LifeCycle1Activity onDestroy() \n";
        tv1 = (TextView) findViewById(R.id.LeftCycleText1);
        tv1.setText(LifeCycle1Activity.res);
        res = "";
    }
}