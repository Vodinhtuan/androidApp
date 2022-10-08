package com.example.tienngoc_bai8_callsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class send_sms extends AppCompatActivity {
    EditText edtSms;
    ImageButton btnSms;
    Button btnBack2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        edtSms = findViewById(R.id.edtSms);
        btnBack2 = findViewById(R.id.btnBack2);
        btnSms = findViewById(R.id.btnSms);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai bao Intent Ẩn để gọi đến ứng dụng gửi tin nhắn
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+edtSms.getText().toString()));
                startActivity(smsIntent);
            }
        });
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}