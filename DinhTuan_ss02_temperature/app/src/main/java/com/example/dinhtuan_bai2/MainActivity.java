package com.example.dinhtuan_bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    // Khai báo các biến giao diện:
    EditText edtF, edtC;
    Button btnCF, btnFC, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Ánh xạ id:
        edtC = findViewById(R.id.edtC);
        edtF = findViewById(R.id.edtF);
        btnCF = findViewById(R.id.btnCF);
        btnFC = findViewById(R.id.btnFC);
        btnClear = findViewById(R.id.btnClear);
        // Xử lý click:
        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("0.00");
                int C = Integer.parseInt(edtC.getText().toString());
                double F = C*1.8 + 32;
                edtF.setText(dcf.format(F)+"");

            }
        });
        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DecimalFormat dcf = new DecimalFormat("0.00");
                int F = Integer.parseInt(edtF.getText().toString());
                double C = (F-32)/1.8;
                edtC.setText(dcf.format(C)+"");

            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("");
                edtF.setText("");
                edtF.requestFocus(); // đưa con trỏ người dùng về edtF
            }
        });
    }
}