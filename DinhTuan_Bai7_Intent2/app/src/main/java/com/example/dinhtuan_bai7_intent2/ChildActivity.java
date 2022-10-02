package com.example.dinhtuan_bai7_intent2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class ChildActivity extends AppCompatActivity {
    Button btnBack;
    EditText txtKQ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        btnBack = findViewById(R.id.edtBack);
        txtKQ = findViewById(R.id.txtKQ);

        Intent callerIntent1 = getIntent();
        Bundle backagecaller1 = callerIntent1.getBundleExtra("mybackage");
        int a = backagecaller1.getInt("soa");
        int b = backagecaller1.getInt("sob");
        String kq = "";
        if(a==0 && b==0){
            kq = "Vô số ngiệm";
        }else if(a==0 && b!=0){
            kq = "Vô nghiệm";
        }else {
            DecimalFormat dcf = new DecimalFormat("0.##");
            kq = dcf.format(-b*1.0/a);
        }
        txtKQ.setText(kq);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}