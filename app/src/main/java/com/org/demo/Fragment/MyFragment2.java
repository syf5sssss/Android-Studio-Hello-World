package com.org.demo.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.org.helloworld.R;

public class MyFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_myfragment2, container, false);
        String name = (String) getArguments().get("name");
        Log.e("ttit", "MyFragment2 Get name = " + name);
        return view;
    }

    public void setCallBack(CallBack callBack) {
        Log.e("ttit", "MyFragment2  setCallBack " );
        String msg = "传递给宿主FragActivity的数据";
        callBack.getResult(msg);
    }

    public interface CallBack {
        void getResult(String result);
    }
}
