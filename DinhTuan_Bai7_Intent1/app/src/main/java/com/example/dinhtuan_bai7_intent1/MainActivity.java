package com.example.dinhtuan_bai7_intent1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     Button btnOpen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnOpen = findViewById(R.id.btnOpen);
        // Click
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Khai báo Intent để mở từ MainActivity sang ChildActivity
                Intent myIntent = new Intent(MainActivity.this, activity_child.class);
                // Khởi động
                startActivity(myIntent);
            }
        });
    }
}