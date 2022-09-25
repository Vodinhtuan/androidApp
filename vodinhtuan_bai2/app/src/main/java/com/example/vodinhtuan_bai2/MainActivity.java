package com.example.vodinhtuan_bai2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtVND, edtNgoaiTe;
    Button btnClear, btnVndtoNgoaiTe, btnNgoaiteToVnd;
    RadioGroup idRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtVND = findViewById(R.id.edtVND);
        edtNgoaiTe = findViewById(R.id.edtNgoaiTe);
        btnClear = findViewById(R.id.btnClear);
        btnNgoaiteToVnd = findViewById(R.id.btnNgoaiteToVnd);
        btnVndtoNgoaiTe = findViewById(R.id.btnVndtoNgoaiTe);
        idRadioGroup = findViewById(R.id.idRadioGroup);

        btnVndtoNgoaiTe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ketqua;
                String check = "";

                int idSelect = idRadioGroup.getCheckedRadioButtonId();
                RadioButton radioSelect = findViewById(idSelect);
                check = radioSelect.getText().toString();

                DecimalFormat dcf = new DecimalFormat("0.0");

                double vnd = Double.parseDouble(edtVND.getText().toString());

                switch (check){
                    case "USD":{
                        ketqua = vnd/22280;
                        edtNgoaiTe.setText(dcf.format(ketqua));
                        break;
                    }
                    case "EUR":{
                        ketqua = vnd/24280;
                        edtNgoaiTe.setText(dcf.format(ketqua));
                        break;
                    } case "JPY":{
                        ketqua = vnd/204;
                        edtNgoaiTe.setText(dcf.format(ketqua));
                        break;
                    }
                }
            }
        });

        btnNgoaiteToVnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double ketqua;
                String check = "";

                int idSelect = idRadioGroup.getCheckedRadioButtonId();
                RadioButton radioSelect = findViewById(idSelect);
                check = radioSelect.getText().toString();

                DecimalFormat dcf = new DecimalFormat("0.0");

                double ngoaiTe = Double.parseDouble(edtNgoaiTe.getText().toString());

                switch (check){
                    case "USD":{
                        ketqua = ngoaiTe*22280;
                        edtVND.setText(dcf.format(ketqua));
                        break;
                    }
                    case "EUR":{
                        ketqua = ngoaiTe*24280;
                        edtVND.setText(dcf.format(ketqua));
                        break;
                    } case "JPY":{
                        ketqua = ngoaiTe*204;
                        edtVND.setText(dcf.format(ketqua));
                        break;
                    }
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNgoaiTe.setText("");
                edtVND.setText("");
                edtVND.requestFocus();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Make AlertDialog
        AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
        myDialog.setTitle("Question?");
        myDialog.setMessage("Are you sure you want to exit? ");

        myDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish(); // Thoát ứng dụng
            }
        });

        myDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel(); // Thoát dialog
            }
        });

        myDialog.create().show(); // Hiển thị
    }
}
