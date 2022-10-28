package com.org.demo.BroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.org.demo.BroadCast1Activity;

public class DynamicBRReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("T","收到广播");
        BroadCast1Activity.str = BroadCast1Activity.str +"收到广播 \n";
        String val = intent.getStringExtra("Name");
        BroadCast1Activity.str = BroadCast1Activity.str +" --> "+val+" \n";
        BroadCast1Activity.AddMessage(BroadCast1Activity.str);
        Log.e("T","DynamicBRReceiver: 收到广播！！！ "+val);
//        Toast.makeText(context, "DynamicBRReceiver: 收到广播！！！ "+val, Toast.LENGTH_SHORT).show();
    }
}