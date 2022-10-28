package com.org.demo.BroadCast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.org.demo.BroadCast1Activity;
import com.org.demo.BroadCast2Activity;

// 静态注册
public class StaticBRReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("T","收到广播");
        BroadCast2Activity.str = BroadCast2Activity.str +"收到广播 \n";
        String val = intent.getStringExtra("Name");
        BroadCast2Activity.str = BroadCast2Activity.str +" --> "+val+" \n";
        BroadCast2Activity.AddMessage(BroadCast2Activity.str);
        Log.e("T","StaticBRReceiver: 收到广播！！！ "+val);

//        Toast.makeText(context, "StaticBRReceiver: 收到广播！！！ "+val, Toast.LENGTH_SHORT).show();
    }
}
