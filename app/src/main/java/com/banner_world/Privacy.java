package com.banner_world;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class Privacy extends AppCompatActivity {
    WebView webView;
    private String filename ="Banner_Privacy.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        webView = (WebView) findViewById(R.id.privacy);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("file:///android_asset/"+filename);

    }
}