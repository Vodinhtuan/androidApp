package com.example.dinhtuan_bai10_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edtlink;
    Button btnopen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnopen = findViewById(R.id.btnopen);
        edtlink = findViewById(R.id.edtlink);

        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai báo Intent Ẩn để gọi đến úng dụng mở link web
                Intent myintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+edtlink.getText().toString()));
                startActivity(myintent);
            }
        });
    }
}