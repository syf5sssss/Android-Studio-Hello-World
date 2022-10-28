package com.org.demo.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MLinearLayout extends LinearLayout {
    public MLinearLayout(Context context) {
        super(context);
    }

    public MLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.e("ttit", "MLinearLayout ://////onTouchEvent event ="+event.getAction());
        DispatchActivity.result1 = DispatchActivity.result1 +"LinearLayout : onTouchEvent action:"+event.getAction()+"  \n";
        return false;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("ttit", "MLinearLayout ://////onInterceptTouchEvent");
        DispatchActivity.result1 = DispatchActivity.result1 +"LinearLayout : onInterceptTouchEvent \n";
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("ttit", "MLinearLayout ://////dispatchTouchEvent");
        DispatchActivity.result1 = DispatchActivity.result1 +"LinearLayout : dispatchTouchEvent \n";
        return super.dispatchTouchEvent(ev);
//        return false;
    }
}
