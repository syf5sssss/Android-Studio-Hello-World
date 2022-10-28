package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.org.helloworld.R;

public class EditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        EditText eName = findViewById(R.id.etName);
        eName.requestFocus();
        eName.setSelection(2);
    }
}