package com.example.dinhtuan_bai7_intent3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnKQ;
    EditText edtA, edtB, txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnKQ = findViewById(R.id.btnKQ);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        txtKQ = findViewById(R.id.txtKQ);

        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, childActivity.class);
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                intent.putExtra("soA",a);
                intent.putExtra("soB",b);
                // Khởi động intent và chờ kết quả
                startActivityForResult(intent,99);
            }
        });
    }

    // nhận kết quả
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode ==33){
            int sum = data.getIntExtra("kq", 0);
            txtKQ.setText("Tổng 2 số là: " + sum);
        }
        if(requestCode == 99 && resultCode == 35){
            int sub = data.getIntExtra("kq",0);
            txtKQ.setText("Hiệu 2 số là: " + sub);
        }
    }
}