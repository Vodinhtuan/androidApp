package com.example.dinhtuan_bai13_customlistviewnangcao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

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