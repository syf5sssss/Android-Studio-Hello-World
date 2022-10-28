package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.org.helloworld.R;

public class DailogShow1Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailog_show1);
        Log.e("ttit", "执行生命周期函数: DailogShow1Activity onCreate() ===");
        LifeCycle1Activity.res = LifeCycle1Activity.res +"执行生命周期函数:=== DailogShow1Activity onCreate() \n";
        LifeCycle1Activity.tv1 = (TextView) findViewById(R.id.LeftCycleText1);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ttit", "执行生命周期函数: DailogShow1Activity onStart() ===");
        LifeCycle1Activity.res = LifeCycle1Activity.res +"执行生命周期函数:=== DailogShow1Activity onStart() \n";
        LifeCycle1Activity.tv1 = (TextView) findViewById(R.id.LeftCycleText1);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ttit", "执行生命周期函数: DailogShow1Activity onResume() ===");
        LifeCycle1Activity.res = LifeCycle1Activity.res +"执行生命周期函数:=== DailogShow1Activity onResume() \n";
        LifeCycle1Activity.tv1 = (TextView) findViewById(R.id.LeftCycleText1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ttit", "执行生命周期函数: DailogShow1Activity onPause() ===");
        LifeCycle1Activity.res = LifeCycle1Activity.res +"执行生命周期函数:=== DailogShow1Activity onPause() \n";
        LifeCycle1Activity.tv1 = (TextView) findViewById(R.id.LeftCycleText1);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("ttit", "执行生命周期函数: DailogShow1Activity onStop() ===");
        LifeCycle1Activity.res = LifeCycle1Activity.res +"执行生命周期函数:=== DailogShow1Activity onStop() \n";
        LifeCycle1Activity.tv1 = (TextView) findViewById(R.id.LeftCycleText1);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("ttit", "执行生命周期函数: DailogShow1Activity onRestart() ===");
        LifeCycle1Activity.res = LifeCycle1Activity.res +"执行生命周期函数:=== DailogShow1Activity onRestart() \n";
        LifeCycle1Activity.tv1 = (TextView) findViewById(R.id.LeftCycleText1);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ttit", "执行生命周期函数: DailogShow1Activity onDestroy() ===");
        LifeCycle1Activity.res = LifeCycle1Activity.res +"执行生命周期函数:=== DailogShow1Activity onDestroy() \n";
        LifeCycle1Activity.tv1 = (TextView) findViewById(R.id.LeftCycleText1);
    }
}