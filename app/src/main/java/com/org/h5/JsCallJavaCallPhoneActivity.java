package com.org.h5;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;

import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.org.helloworld.R;

/**
 * 作用：java和js互调
 */
public class JsCallJavaCallPhoneActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_call_java_video);
        webView = (WebView) findViewById(R.id.webview2);
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
        webView.addJavascriptInterface(new AndroidAndJSInterface(), "Android");

        //加载本地资源
//        webView.loadUrl("http://atguigu.com/teacher.shtml");
        webView.loadUrl("file:///android_asset/JsCallJavaCallPhone.html");
//        webView.loadUrl("http://10.0.2.2:8080/assets/JsCallJavaCallPhone.html");

    }

    class AndroidAndJSInterface {
        /**
         * 该方法将被js调用,用于加载数据
         */
        @JavascriptInterface
        public void showcontacts() {

            // 调用JS中的方法
            JsCallJavaCallPhoneActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // 下面的代码建议在子线程中调用
                    String json = "[{\"name\":\"唐僧\", \"phone\":\"8848\"}]";
                    webView.loadUrl("javascript:show('" + json + "')");
                }
            });

        }

        /**
         * 拨打电话
         */
        @JavascriptInterface
        public void call(String phone) {
            try {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
                Log.e("org","phone:"+phone);
                startActivity(intent);
                Log.e("org","start 拨打电话 Activity");
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(JsCallJavaCallPhoneActivity.this, "还需要确认应用授予权限", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
