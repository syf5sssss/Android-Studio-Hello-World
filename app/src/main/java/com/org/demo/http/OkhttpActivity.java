package com.org.demo.http;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.org.helloworld.R;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpActivity extends AppCompatActivity {
    private EditText tvRes;
    private String url = "https://www.baidu.com/home/other/data/weatherInfo?city=%E4%B8%8A%E6%B5%B7&indextype=manht&_req_seqid=0x9bf9106c001a946f&asyn=1&t=1628558339805&sid=34401_34335_34273_31253_34403_33848_34073_34092_34094_26350";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        tvRes = findViewById(R.id.et_res);
        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get();
            }
        });
        findViewById(R.id.btn_post).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post();
            }
        });
    }

    /**
     * 异步get请求
     */
    private void get() {
        try {
            //第一步获取okHttpClient对象
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();
            //第二步构建Request对象
            Request request = new Request.Builder()
                    .url(url)
                    .get()
                    .build();
            //第三步构建Call对象
            Call call = client.newCall(request);
            //第四步:异步get请求
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    tvRes.setText(e.getMessage());
                    Log.i("ttit", e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    //得到的子线程
                    String result = response.body().string();
                    Log.e("ttit", result);
                    tvRes.setText(result);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 异步post请求
     */
    private void post() {
        //第一步创建OKHttpClient
        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();
            //第二步创建RequestBody（Form表达）
//        RequestBody body = new FormBody.Builder()
//                .add("mobile", "demoData")
//                .add("password", "demoData")
//                .build();
            Map m = new HashMap();
            m.put("username", "admin");
            m.put("password", "12345");
            JSONObject jsonObject = new JSONObject(m);
            String jsonStr = jsonObject.toString();
            RequestBody requestBodyJson =
                    RequestBody.create(MediaType.parse("application/json;charset=utf-8")
                            , jsonStr);
            //第三步创建Rquest
            Request request = new Request.Builder()
                    .url("http://192.168.31.32:8080/renren-fast/app/login")
                    .addHeader("contentType", "application/json;charset=UTF-8")
                    .post(requestBodyJson)
                    .build();
            //第四步创建call回调对象
            final Call call = client.newCall(request);
            //第五步发起请求
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    tvRes.setText(e.getMessage());
                    Log.i("onFailure", e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String result = response.body().string();
                    tvRes.setText(result);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
