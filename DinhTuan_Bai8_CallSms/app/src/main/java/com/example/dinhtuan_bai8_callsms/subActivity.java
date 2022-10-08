package com.example.dinhtuan_bai8_callsms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class subActivity extends AppCompatActivity {
    EditText edtPhone;
    ImageButton btnCall;
    Button btnBackCall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edtPhone = findViewById(R.id.edtPhone);
        btnBackCall = findViewById(R.id.btnBackCall);
        btnCall = findViewById(R.id.btnCall);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai bao Intent Ẩn gọi đến  ứng dụng Gọi Điện
                Intent callintent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edtPhone.getText().toString()));

                // Yêu cầu người dùng cho phép truy cập vào chức năng của hệ thống.
                if (ActivityCompat.checkSelfPermission(subActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(subActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                    return;
                }
                startActivity(callintent);
            }
        });

        btnBackCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}