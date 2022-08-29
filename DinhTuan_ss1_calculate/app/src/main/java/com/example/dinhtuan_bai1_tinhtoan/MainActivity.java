package com.example.dinhtuan_bai1_tinhtoan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // khai báo các biến giao diện
    EditText edtA, edtB, edtResult;
    Button btnTong, btnHieu, btnTich, btnThuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ Id cho các giao diện:

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtResult = findViewById(R.id.edtResult);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        btnTich = findViewById(R.id.btnTich);
        btnThuong = findViewById(R.id.btnThuong);

        // Xứ lý tương tác với người dùng:

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString()); // Lấy dữ liều từ edtA ép từ String sang kiểu int và gán vào biến a
                int b = Integer.parseInt(edtB.getText().toString()); // Lấy dữ liều từ edtB ép từ String sang kiểu int và gán vào biến b
                int c = a + b;
                edtResult.setText(c + " "); // Hiển thị kết quả ( cộng với chuỗi rỗng để ép dữ liệu từ int sang String
            }
        });
        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString()); // Lấy dữ liều từ edtA ép từ String sang kiểu int và gán vào biến a
                int b = Integer.parseInt(edtB.getText().toString()); // Lấy dữ liều từ edtB ép từ String sang kiểu int và gán vào biến b
                int c = a - b;
                edtResult.setText(c + " "); // Hiển thị kết quả ( trừ với chuỗi rỗng để ép dữ liệu từ int sang String
            }
        });
        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString()); // Lấy dữ liều từ edtA ép từ String sang kiểu int và gán vào biến a
                int b = Integer.parseInt(edtB.getText().toString()); // Lấy dữ liều từ edtB ép từ String sang kiểu int và gán vào biến b
                int c = a * b;
                edtResult.setText(c + " "); // Hiển thị kết quả ( nhân với chuỗi rỗng để ép dữ liệu từ int sang String
            }
        });
        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString()); // Lấy dữ liều từ edtA ép từ String sang kiểu int và gán vào biến a
                int b = Integer.parseInt(edtB.getText().toString()); // Lấy dữ liều từ edtB ép từ String sang kiểu int và gán vào biến b
                int c = a / b;
                edtResult.setText(c + " "); // Hiển thị kết quả ( chia với chuỗi rỗng để ép dữ liệu từ int sang String
            }
        });
    }
}