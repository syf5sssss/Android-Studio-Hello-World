package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.org.helloworld.R;

public class CheckBoxActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private CheckBox cb_one;
    private CheckBox cb_two;
    private CheckBox cb_three;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        cb_one = (CheckBox) findViewById(R.id.cb_one);
        cb_two = (CheckBox) findViewById(R.id.cb_two);
        cb_three = (CheckBox) findViewById(R.id.cb_three);
        btn_send = (Button) findViewById(R.id.btn_send);

        cb_one.setOnCheckedChangeListener(this);
        cb_two.setOnCheckedChangeListener(this);
        cb_three.setOnCheckedChangeListener(this);
        btn_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String choose = "";
        if (cb_one.isChecked()) choose += cb_one.getText().toString() + "";
        if (cb_two.isChecked()) choose += cb_two.getText().toString() + "";
        if (cb_three.isChecked()) choose += cb_three.getText().toString() + "";
        Toast.makeText(this, choose, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String s = buttonView.getText().toString();
        if (buttonView.isChecked()) {
            Toast.makeText(this, buttonView.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}