package com.example.dinhtuan_bai11_listview1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtPhone;
    // Cac thuoc tinh di kem ListView
    // 1. Mang du lieu
    String myphone[] = {" Dien thoai Iphone"," Dien thoai SamSung", " Dien thoai Vivo", " Dien thoai Oppo", " Dien thoai Nokia"};
    // 2. Khai bao Adapter
    ArrayAdapter<String> myAdapter;
    // 3. Khai bao ListView
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPhone = findViewById(R.id.txtPhone);
        lv = findViewById(R.id.lv);

        // Tao moi Adapter
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, myphone);
        // gan adapter cho ListView
        lv.setAdapter(myAdapter);

        // Xu ly click cho listView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtPhone.setText("Vi tri " + i + ": " + myphone[i]);
            }
        });
    }
}