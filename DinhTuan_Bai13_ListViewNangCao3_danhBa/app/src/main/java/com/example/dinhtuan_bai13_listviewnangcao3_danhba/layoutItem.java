package com.example.dinhtuan_bai13_listviewnangcao3_danhba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class layoutItem extends AppCompatActivity {
    ImageButton btnCall, btnSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_item);

        btnCall = findViewById(R.id.btnCall);
        btnSms = findViewById(R.id.btnSms);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai bao Intent cong khai
                Intent intent1 = new Intent(MainActivity.this, subActivity.class);
                startActivity(intent1);
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai bao Intent cong khai
                Intent intent2 = new Intent(MainActivity.this, sendSmsActivity.class);
                startActivity(intent2);
            }
        });

    }
}