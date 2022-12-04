package com.example.dinhtuan_bai15_sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btnSum, btnClear;
    TextView txtLichSu;
    String lichSu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKQ);
        btnSum = findViewById(R.id.btnSum);
        btnClear = findViewById(R.id.btnClear);
        txtLichSu = findViewById(R.id.txtLichSu);
        // Lấy lại dữ liệu
        //1. Tạo lại đối tượng
        // Tạo đối tượng Shared ...
        SharedPreferences preferences = getSharedPreferences("Sum", MODE_PRIVATE);
        //2. Đọc lại data
        lichSu = preferences.getString("ls", "");
        txtLichSu.setText(lichSu);

        // Xử lý click Sum
        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                int kq = a + b;
                edtKQ.setText(kq + "");
                lichSu += a + " + " + b + " = " + kq + "\n";
                txtLichSu.setText(lichSu);
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lichSu = "";
                txtLichSu.setText(lichSu);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Tạo đối tượng Shared ...
        SharedPreferences preferences = getSharedPreferences("Sum", MODE_PRIVATE);
        // Tạo đối tượng
        SharedPreferences.Editor editor = preferences.edit();
        // Thêm dữ liệu
        editor.putString("ls", lichSu);
        editor.commit();
    }
}