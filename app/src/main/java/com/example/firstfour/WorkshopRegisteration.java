package com.example.firstfour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URISyntaxException;

public class WorkshopRegisteration extends AppCompatActivity {
    String currentUrl="https://forms.gle/M6hjmCE8qzUrhGg99";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop_registeration);

        WebView w = (WebView) findViewById(R.id.web);

       // w.loadUrl("https://forms.gle/M6hjmCE8qzUrhGg99");

        WebSettings webSettings = w.getSettings();
        webSettings.setJavaScriptEnabled(true);

        w.loadUrl(currentUrl);

//        w.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                currentUrl = url;
//                if (url.startsWith("http") || url.startsWith("https")) {
//                   w.loadUrl("https://forms.gle/M6hjmCE8qzUrhGg99");
//                }
//                if (url.startsWith("intent")) {
//                    try {
//                        Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
//                        String fallbackUrl = intent.getStringExtra("browser_fallback_url");
//                        if (fallbackUrl != null) {
//                            w.loadUrl(fallbackUrl);
//                            return true;
//                        }
//                    } catch (URISyntaxException e) {
//                        //not an intent uri
//                    }
//                    return true;//do nothing in other cases
//                }
//
//                return false;
//            }
//        });
    }
}