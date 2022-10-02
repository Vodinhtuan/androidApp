package com.example.dinhtuan_bai7_intent3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class childActivity extends AppCompatActivity {
    Button btnTong, btnHieu;
    EditText txtA, txtB;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);
        btnTong = findViewById(R.id.btnTong);
        btnHieu = findViewById(R.id.btnHieu);
        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);

        // Nhận intent:
        intent = getIntent();
        // Lấy dữ liệu khỏi intent và hiển thị
        int a = intent.getIntExtra("soA",0);
        int b = intent.getIntExtra("soB",0);

        txtA.setText(a+"");
        txtB.setText(b+"");

        // Xử lý và trả kết quả trở về
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // tính tổng
               int sum = a + b;
               // Đưa tổng vào lại intent
               intent.putExtra("kq",sum);
               // Đẩy intent về MainActivity
                setResult(33,intent);
                finish();
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // tính hiệu
                int sub = a - b;
                // Đưa hiệu vào lại intent
                intent.putExtra("kq",sub);
                // Đẩy intent về MainActivity
                setResult(35,intent);
                finish();
            }
        });
    }
}