package com.example.dinhtuan_ss03_demorcyclefile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"CR424 - onCreat()",Toast.LENGTH_SHORT).show();
        btnCall = findViewById(R.id.btnCall);
        // xu ly click
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // khai bao Intent de goi subActivity
                Intent intent1 = new Intent(MainActivity.this,subActivity.class);
                //Khoi dong Intent
                startActivity(intent1);
            }
        });
    }

    @Override
    protected void onDestroy() {
// TODO Auto-generated method stub
        super.onDestroy();
        Toast.makeText(this,"CR424 - on Destroy()",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
// TODO Auto-generated method stub
        super.onPause();
        Toast.makeText(this," CR424 - onPause", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
// TODO Auto-generated method stub
        super.onRestart();
        Toast.makeText(this," CR424 - onRestart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
// TODO Auto-generated method stub
        super.onResume();
        Toast.makeText(this," CR424 - onResume", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
// TODO Auto-generated method stub
        super.onStart();
        Toast.makeText(this," CR424 - onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
// TODO Auto-generated method stub
        super.onStop();
        Toast.makeText(this," CR424 - onStop", Toast.LENGTH_SHORT).show();
    }
    // chuot phai chon genernal nhan ctrl de chon 1 luc nhieu ham
    // Toast: thong bao

}