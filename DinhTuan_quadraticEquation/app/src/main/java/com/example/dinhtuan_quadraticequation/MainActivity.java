package com.example.dinhtuan_quadraticequation;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnContinue, btnResult, btnExit;
    EditText edtA, edtB, edtC;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnContinue = findViewById(R.id.btnContinue);
        btnExit = findViewById(R.id.btnExit);
        btnResult = findViewById(R.id.btnResult);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        txtResult = findViewById(R.id.txtResult);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                edtA.requestFocus();
            }
        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                String sA = edtA.getText()+"";
                String sB = edtB.getText()+"";
                String sC = edtC.getText()+"";
                int a = Integer.parseInt(sA);
                int b = Integer.parseInt(sB);
                int c = Integer.parseInt(sC);
                String result = "";
                DecimalFormat dcf = new DecimalFormat("#.00");
                double delta = b*b-4*a*c;
                if(delta<0){
                    result = "The equation has no solution!";
                }else if(delta==0){
                    result = "The equation has a double solution: x1= x2= " + dcf.format(-b/(2*a));
                }else {
                    result = "The equation has 2 solutions:\n x1= " + dcf.format((-b+Math.sqrt(delta))/(2*a)) + "\n" +
                            "\t x2= " + dcf.format((b-Math.sqrt(delta))/(2*a));
                }
                txtResult.setText(result);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}