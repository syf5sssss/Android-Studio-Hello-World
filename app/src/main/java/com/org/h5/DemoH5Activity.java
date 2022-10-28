package com.org.h5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.org.helloworld.R;

/**
 * java和js互调
 */
public class DemoH5Activity extends Activity implements View.OnClickListener {

    private Button btnJavaAndJs;
    private Button btnJsCallJava;
    private Button btnJsCallPhone;


    private void findViews() {
        btnJavaAndJs = (Button)findViewById( R.id.btn_java_and_js );
        btnJsCallJava = (Button)findViewById( R.id.btn_js_call_java );
        btnJsCallPhone = (Button)findViewById( R.id.btn_js_call_phone );

        btnJavaAndJs.setOnClickListener( this );
        btnJsCallJava.setOnClickListener( this );
        btnJsCallPhone.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        if ( v == btnJavaAndJs ) {
            // Handle clicks for btnJavaAndJs
            Intent intent = new Intent(this, com.org.h5.JavaAndJSActivity.class);
            startActivity(intent);
        } else if ( v == btnJsCallJava ) {
            // Handle clicks for btnJsCallJava
            Intent intent = new Intent(this, com.org.h5.JsCallJavaVideoActivity.class);
            startActivity(intent);
        } else if ( v == btnJsCallPhone ) {
            // Handle clicks for btnJsCallPhone
            Intent intent = new Intent(this, com.org.h5.JsCallJavaCallPhoneActivity.class);
            startActivity(intent);
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_h5);
        findViews();
    }


}
