package com.example.testcustomlistviewnangcao;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class subActivity extends AppCompatActivity {
    TextView txtSubPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        txtSubPhone = findViewById(R.id.txtSubPhone);
        // Nhận intent
        Intent myintent = getIntent();
        // Lấy dữ liệu
        String namephone = myintent.getStringExtra("name");
        txtSubPhone.setText(namephone);
    }
}