package com.org.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import com.org.helloworld.R;

public class GridViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        //AdapterView-- V
        GridView listView = findViewById(R.id.gridView);
        //数据源-- M
        String[] strs = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s"};
        //控制器-- C
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_expandable_list_item_1, strs);
        //为ListView设置Adapter适配器
        listView.setAdapter(adapter);
    }
}