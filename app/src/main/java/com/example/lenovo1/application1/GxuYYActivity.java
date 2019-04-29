package com.example.lenovo1.application1;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class GxuYYActivity extends AppCompatActivity {

    private WebView mWvMain;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gxu_yy);
        mWvMain = (WebView) findViewById(R.id.wv);

        //用来加载加载网络Url   也有可以用本地html文件加载网址的实现本法
        mWvMain.getSettings().setJavaScriptEnabled(true);
        mWvMain.setWebViewClient(new MyWebViewClient());
        mWvMain.setWebChromeClient(new MyWebChromeClient());                         //wcc能实现的各种方法在全部在下面展示
        //ejsp方法 mWvMain.evaluateJavascript();
        mWvMain.loadUrl("https://baike.baidu.com/item/广西大学医院/7093315");
        WebSettings settings = mWvMain.getSettings();//实现缩放
        settings.setBuiltInZoomControls(true); // 显示放大缩小
        settings.setSupportZoom(true); // 可以缩放
        settings.setUseWideViewPort(true);  //为图片添加放大缩小功能
    }
    //自写类继承webviewclient
    class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {//webview方法之一
            view.loadUrl(request.getUrl().toString());
            return true;
        }
        //下面onpage是webviewclient的方法之二
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("webview","onPageStarted...");
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("webview","onPageFinished...");
        }
    }

    //自写类继承webchromeclient
    class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {//wcc进度条方法
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {//实现网页标题名方法
            super.onReceivedTitle(view, title);
            setTitle(title);//就是把网页的标题弄到activity里面去
        }
    }


    //这个方法可以实现点击返回键不推出到activity的方法

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWvMain.canGoBack()){
            mWvMain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

