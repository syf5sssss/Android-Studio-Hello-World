package com.org.h5;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.org.helloworld.R;

/**
 * 作用：java和js互调
 */
public class JavaAndJSActivity extends Activity implements View.OnClickListener {
    private EditText etNumber;
    private EditText etPassword;
    private Button btnLogin;
    /**
     * 加载网页或者说H5页面
     */
    private WebView webView;


    private void findViews() {
        setContentView(R.layout.activity_java_and_js);
        etNumber = (EditText) findViewById(R.id.et_number);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);

        initWebView();
    }


    /**
     * 点击登录按钮
     */
    @Override
    public void onClick(View v) {
        if (v == btnLogin) {
            // Handle clicks for btnLogin
            login();
        }
    }

    /**
     * 尝试登录
     */
    private void login() {
        String numebr = etNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if (TextUtils.isEmpty(numebr) || TextUtils.isEmpty(password)) {
            Toast.makeText(JavaAndJSActivity.this, "账号或者密码为空", Toast.LENGTH_SHORT).show();
        } else {
            //登录
            login(numebr);
        }
    }

    /**
     *  登录成功  Java调用javaScript
     */
    private void login(String numebr) {
        webView.loadUrl("javascript:javaCallJs(" + "'" + numebr + "'" + ")");
        setContentView(webView);
    }

    private void initWebView() {
        webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        //设置支持javaScript脚步语言
        webSettings.setJavaScriptEnabled(true);

        //支持双击-前提是页面要支持才显示
//        webSettings.setUseWideViewPort(true);

        //支持缩放按钮-前提是页面要支持才显示
        webSettings.setBuiltInZoomControls(true);

        //设置客户端-不跳转到默认浏览器中
        webView.setWebViewClient(new WebViewClient());

        //设置支持js调用java
        webView.addJavascriptInterface(new AndroidAndJSInterface(),"Android");

        //加载网络资源
//        webView.loadUrl("http://10.0.2.2:8080/assets/JavaAndJavaScriptCall.html");
        webView.loadUrl("file:///android_asset/JavaAndJavaScriptCall.html");

        //显示页面
//        setContentView(webView);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViews();
    }


    /**
     * js可以调用该类的方法
     */
    class AndroidAndJSInterface{

        @JavascriptInterface
        public void showToast(){
            Toast.makeText(JavaAndJSActivity.this, "我被js调用了", Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void showToast(String str){
            Toast.makeText(JavaAndJSActivity.this, "我被js调用了,参数:"+str, Toast.LENGTH_SHORT).show();
        }

        @JavascriptInterface
        public void lastView(){
            JavaAndJSActivity.this.finish();
//            Toast.makeText(JavaAndJSActivity.this, "我被js调用了,退回", Toast.LENGTH_SHORT).show();
        }
    }


}
