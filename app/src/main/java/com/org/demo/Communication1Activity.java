package com.org.demo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.org.helloworld.R;

public class Communication1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communication1);

        try {
            Button btn2 = findViewById(R.id.commbtn2);
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("tag", "button 1");
                    Intent in = new Intent(Communication1Activity.this, Result1Activity.class);
                    //1.传单个数据
                    in.putExtra("Intent.putExtra","Intent-Test");
                    in.putExtra("Number",100);
                    startActivity(in);
                }
            });
            Button btn3 = findViewById(R.id.commbtn3);
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Communication1Activity.this, Result1Activity.class);
                    //2.传多个数据
                    Bundle b = new Bundle();
                    b.putInt("Number", 200);
                    b.putString("Bundle", "Bundle-Test");
                    in.putExtras(b);
                    startActivity(in);

                }
            });

            Button btn4 = findViewById(R.id.commbtn4);
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Communication1Activity.this, Result1Activity.class);
                    //返回数据给Communication1Activity
                    startActivityForResult(in, 1001);
                }
            });
        } catch (Exception e) {
            Log.e("tag", "Communication1Activity onCreate err");
            Log.e("tag", ""+e.getMessage());
            Log.e("tag", ""+e.getStackTrace());
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView tv1 = (TextView) findViewById(R.id.commtext1);
        String res = "";
        res= res + "requestCode = "+requestCode+" \n";
        res= res + "resultCode = "+resultCode+" \n";
        res= res + "data = "+data.getStringExtra("back")+"\n";
        Log.e("tag", "requestCode =" + requestCode);
        Log.e("tag", "resultCode =" + resultCode);
        Log.e("tag", "data =" + data.getStringExtra("back"));
        tv1.setText(res);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}