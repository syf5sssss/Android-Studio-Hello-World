package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.org.demo.dispatch.DispatchActivity;
import com.org.helloworld.R;

public class Result1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result1);
        Log.e("tag", "Result1Activity = onCreate ");
        String res = "";
        TextView tv1 = (TextView) findViewById(R.id.restext1);

        Intent in = getIntent();
        String val = in.getStringExtra("Intent.putExtra");
        int val2 = in.getIntExtra("Number", 0);
        if(val == null || val.equals(""))
        {
            res = res + "Intent.putExtra: null\n";
        }
        else
        {
            res = res + "Intent.putExtra: "+val+"\n";
        }
        res = res + "Intent.Number: "+val2+"\n\n";
        Log.e("tag", "val =" + val);
        Log.e("tag", "val2 =" + val2);

        Bundle b = in.getExtras();
        if(b!=null)
        {
            String val3 = b.getString("Bundle");
            int val4 = b.getInt("Number");
            Log.e("tag", "val3 =" + val3);
            Log.e("tag", "val4 =" + val4);
            if(val3 == null || val3.equals(""))
            {
                res = res + "Bundle: null\n";
            }
            else
            {
                res = res + "Bundle: "+val3+"\n";
            }
            res = res + "Bundle.Number: "+val4+"\n\n";
        }




        Intent backIn = new Intent();
        backIn.putExtra("back", "Back-Test");
        setResult(1002, backIn);



        tv1.setText(res);
    }
}