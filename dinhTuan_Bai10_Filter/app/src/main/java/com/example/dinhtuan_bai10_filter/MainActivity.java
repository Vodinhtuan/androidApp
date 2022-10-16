package com.example.dinhtuan_bai10_filter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView myWeb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myWeb = findViewById(R.id.myWeb);
        Intent myIntent = getIntent();
        Uri myLink = myIntent.getData();
        try {
            myWeb.loadUrl(myLink.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}