package com.org.demo.dispatch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class MButton extends Button {

    public MButton(Context context) {
        super(context);
    }

    public MButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e("ttit", "MButton ://////onTouchEvent event ="+event.getAction());
//        return super.onTouchEvent(event);
        DispatchActivity.result1 = DispatchActivity.result1 + "Button : onTouchEvent action:" + event.getAction()+ "  \n";
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e("ttit", "MButton ://////dispatchTouchEvent");
        DispatchActivity.result1 = DispatchActivity.result1 +"Button : dispatchTouchEvent \n";
        return super.dispatchTouchEvent(event);
//        return false;
    }
}
