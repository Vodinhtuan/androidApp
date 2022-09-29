package com.example.dinhtuan_bai7_intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnKQ;
    EditText edtA, edtB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKQ = findViewById(R.id.btnKQ);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);

        //xử lý click
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khai báo Intent
                Intent intent1 = new Intent(MainActivity.this, ChildActivity.class);
                // Khai báo Bundle
                Bundle bundle1 = new Bundle();
                // Lấy dữ liệu
                int a = Integer.parseInt(edtA.getText()+"");
                int b = Integer.parseInt(edtB.getText()+"");
                // Đưa dữ liệu vào Bundle
                bundle1.putInt("soa", a);
                bundle1.putInt("sob", b);
                //
                intent1.putExtra("mybackage", bundle1);
                startActivity(intent1);
            }
        });
    }
}