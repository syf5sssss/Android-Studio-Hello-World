package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.org.helloworld.R;

public class ButtonActivity extends AppCompatActivity {

    private Button btnOne, btnTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnTwo.setOnClickListener(new View.OnClickListener() {  //按钮绑定点击事件
            @Override
            public void onClick(View v) {
                if (btnTwo.getText().toString().equals("按钮不可用")) {
                    btnOne.setEnabled(false);
                    btnTwo.setText("按钮可用");
                } else {
                    btnOne.setEnabled(true);
                    btnTwo.setText("按钮不可用");
                }
            }
        });
    }
}