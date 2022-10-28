package com.org.demo.dispatch;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.org.helloworld.R;

public class DispatchActivity extends AppCompatActivity {

    public static String result1 = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatch);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("ttit", "DispatchActivity ://////dispatchTouchEvent");
        DispatchActivity.result1 = DispatchActivity.result1 +"Activity : dispatchTouchEvent \n";
        return super.dispatchTouchEvent(ev);
//        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("ttit", "DispatchActivity ://////onTouchEvent event ="+event.getAction());
        DispatchActivity.result1 = DispatchActivity.result1 +"Activity : onTouchEvent action:"+event.getAction()+" \n";
        if(event.getAction() == 1)
        {
            TextView tv1 = (TextView) findViewById(R.id.TextViewResult1);
            tv1.setText(DispatchActivity.result1);
            DispatchActivity.result1 = "";
        }
        return false;
    }
}