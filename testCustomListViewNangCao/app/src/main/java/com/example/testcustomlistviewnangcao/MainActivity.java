package com.example.testcustomlistviewnangcao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.testcustomlistviewnangcao.model.Phone;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int imagePhone[] = {R.drawable.samsung,R.drawable.cellphone,R.drawable.htc,R.drawable.ip,R.drawable.lg,R.drawable.sky,R.drawable.wp};
    String namePhone[] = {"Điện thoại SamSung","Điện thoại cellphone","Điện thoại htc","Điện thoại ip","Điện thoại lg", "Điện thoại sky","Điện thoại wp"};
    int pricePhone[] = {1000, 2000, 3000, 4000, 5000, 6000, 7000};
    // Khai báo listView
    ArrayList<Phone> myList;
    myArrayAdapter myAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        // Tạo mới mảng rỗng
        myList  = new ArrayList<>();
        for (int i = 0; i<namePhone.length; i++){
            myList.add(new Phone(imagePhone[i], namePhone[i], pricePhone[i]));
        }
        // Tạo Adapter
        myAdapter = new myArrayAdapter(MainActivity.this,R.layout.layout_item,myList);
        lv.setAdapter(myAdapter);

        // Xử lý click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent myIntent = new Intent(MainActivity.this, subActivity.class);
                myIntent.putExtra("name", namePhone[i]);
                startActivity(myIntent);
            }
        });
    }
}