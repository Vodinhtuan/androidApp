package com.example.dinhtuan_sqlproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Khai báo các biến liên quan đến DataBase
    String DB_PATH_SUFFIX = "/databases/";      // Thư mục mặc định chứa cơ sở dữ liệu trong cache điện thoại
    SQLiteDatabase database = null;             // Khai báo tên cơ sở dữ liệu
    String DATABASE_NAME = "Book.db";           // Tên file chứa dataBase

    // Khai báo listView
    ListView lv;
    ArrayList<String>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}