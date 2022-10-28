package com.org.demo.Fragment;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.org.helloworld.R;

public class FragActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        Log.e("ttit", "FragActivity - onCreate ");
        //动态添加Fragment
        MyFragment2 myFragment = new MyFragment2();
        Bundle b = new Bundle();
        b.putString("name", "jack");
        myFragment.setArguments(b);

        Log.e("ttit", "FragActivity - putString ");
        myFragment.setCallBack(new MyFragment2.CallBack() {
            @Override
            public void getResult(String result) {
                Log.e("ttit", "FragActivity result = " + result);
            }
        });
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.rl_fragment, myFragment);
//        ft.replace(R.id.rl_fragment, myFragment);
//        ft.remove(myFragment);
//        ft.addToBackStack(null); //将事务添加到回退栈
        ft.commit();
        Log.e("ttit", "FragActivity - commit ");
    }
}
