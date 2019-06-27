package com.example.yt.myapplication.ui.activitys;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.yt.myapplication.R;

public class MusicWebMusic extends FragmentActivity {
    private WebView url;
    private String musicurl;
    private WebView web;
    private WebSettings webSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicwebview);
        Intent intent = getIntent();
        musicurl = intent.getStringExtra("musicurl");
        initView();
    }

    WebSettings mWebSettings;
    private void initView() {
        web = (WebView) findViewById(R.id.musicwebview);
        initWeb();
    }
    private void initWeb() {
        web.loadUrl(musicurl);
        mWebSettings = web.getSettings();
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);//设置js可以直接打开窗口，如window.open()，默认为false
        mWebSettings.setJavaScriptEnabled(true);//是否允许JavaScript脚本运行，默认为false。设置true时，会提醒可能造成XSS漏洞
/*        mWebSettings.setSupportZoom(true);//是否可以缩放，默认true
        mWebSettings.setBuiltInZoomControls(true);//是否显示缩放按钮，默认false
        mWebSettings.setUseWideViewPort(true);//设置此属性，可任意比例缩放。大视图模式
        mWebSettings.setLoadWithOverviewMode(true);//和setUseWideViewPort(true)一起解决网页自适应问题
        mWebSettings.setAppCacheEnabled(true);//是否使用缓存
        mWebSettings.setDomStorageEnabled(true);//开启本地DOM存储
        mWebSettings.setLoadsImagesAutomatically(true); // 加载图片*/
        web.setLayerType(View.LAYER_TYPE_HARDWARE,null);
        mWebSettings.setBlockNetworkImage(false) ;
        mWebSettings.setBlockNetworkLoads(false);
        mWebSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE);
        mWebSettings.setMediaPlaybackRequiresUserGesture(false);//播放音频，多媒体需要用户手动？设置为false为可自动播放
        mWebSettings.setAppCacheEnabled(true);//是否使用缓存
        mWebSettings.setDomStorageEnabled(true);//DOM Storage
        mWebSettings.setAllowContentAccess(true);
        mWebSettings.setDatabaseEnabled(true);








        web.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                // TODO Auto-generated method stub
                //返回值是true的时候控制去WebView打开，为false调用系统浏览器或第三方浏览器
                view.loadUrl(url);
                return true;
            }
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
//                showProgress("页面加载中");//开始加载动画
            }

            @Override
            public void onPageFinished(WebView view, String url1) {
                super.onPageFinished(view, url1);
                view.loadUrl("javascript:function setTop(){document.querySelector('.footer-wrap').style.display=\"none\";}setTop();");
               view.loadUrl("javascript:function setTop(){document.querySelector('.m-moreLists').style.display=\"none\";}setTop();");

            }
        });





















    }
}
