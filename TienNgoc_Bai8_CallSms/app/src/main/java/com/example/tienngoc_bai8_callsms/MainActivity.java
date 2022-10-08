package com.example.tienngoc_bai8_callsms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCallPhone, btnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCallPhone = findViewById(R.id.btnCallPhone);
        btnSend = findViewById(R.id.btnSend);

        btnCallPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai bao Intent cong khai
                Intent intent1 = new Intent(MainActivity.this, callActivity.class);
                startActivity(intent1);
            }
        });

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai bao Intent cong khai
                Intent intent2 = new Intent(MainActivity.this, callActivity.class);
                startActivity(intent2);
            }
        });
    }
}