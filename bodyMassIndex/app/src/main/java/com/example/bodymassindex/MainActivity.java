package com.example.bodymassindex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnBMI;
    EditText edtName, edtHeight, edtWeight, edtBMI, edtDiagnostic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBMI = findViewById(R.id.btnBMI);
        edtDiagnostic = findViewById(R.id.edtDiagnostic);
        edtHeight = findViewById(R.id.edtHeight);
        edtName = findViewById(R.id.edtName);
        edtWeight = findViewById(R.id.edtWeight);
        edtBMI = findViewById(R.id.edtBMI);
        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double H = Double.parseDouble(edtHeight.getText()+"");
                double W = Double.parseDouble(edtWeight.getText()+"");
                double BMI = W/Math.pow(H,2);
                String diagnostic = "";
                if (BMI<18){
                    diagnostic = "You are thin!";
                }else if (BMI<=24.9){
                    diagnostic = "You are normal!";
                }else if (BMI<=29.9){
                    diagnostic = "You are obese grade 1!";
                }else if(BMI<=34.9) {
                    diagnostic = "You are obese grade 2!";
                }else{
                    diagnostic = "You are obese grade 3!";
                }
                DecimalFormat dcf=new DecimalFormat("#.0");
                edtBMI.setText(dcf.format(BMI));
                edtDiagnostic.setText(diagnostic);
            }
        });
    }
}