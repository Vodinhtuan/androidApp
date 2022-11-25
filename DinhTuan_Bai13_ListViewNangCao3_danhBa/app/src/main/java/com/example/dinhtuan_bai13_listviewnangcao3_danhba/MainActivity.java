package com.example.dinhtuan_bai13_listviewnangcao3_danhba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.dinhtuan_bai13_listviewnangcao3_danhba.model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String namePhone[] = {"Võ Đình Tuấn", "Nguyễn Văn A", "Lê Văn B", "Ngô Bá Khá"};
    String phoneNumber[] = {"0905192030", "0935253123", "0935953448", "0912345690"};
    // khai báo listView
    ArrayList<Person> myList;
    myArrayAdapter myArrayAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =findViewById(R.id.listView);

        // Tạo mới mảng rỗng
        myList = new ArrayList<>();
        for (int i = 0; i<namePhone.length; i++){
            myList.add(new Person(namePhone[i], phoneNumber[i]));
        }
        // Tạo Adapter
        myArrayAdapter = new myArrayAdapter(MainActivity.this,R.layout.activity_layout_item,myList);
        listView.setAdapter(myArrayAdapter);

    }
}