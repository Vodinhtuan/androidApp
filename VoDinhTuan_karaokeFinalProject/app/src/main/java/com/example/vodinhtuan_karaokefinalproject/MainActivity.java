package com.example.vodinhtuan_karaokefinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;

import com.example.vodinhtuan_karaokefinalproject.adapter.MyArrayAdapter;
import com.example.vodinhtuan_karaokefinalproject.model.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String DB_PATH_SUFFIX = "/databases/";
    public static SQLiteDatabase database=null;
    public static String DATABASE_NAME="arirang.sqlite";
    EditText edttim;
    ListView lv1,lv2,lv3;
    ArrayList<Item> list1, list2, list3;
    MyArrayAdapter myarray1, myarray2, myarray3;
    TabHost tab;
    ImageButton btnxoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}