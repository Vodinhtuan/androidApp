package com.example.vodinhtuan_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vodinhtuan_finalproject.adapter.MyArrayAdapter;
import com.example.vodinhtuan_finalproject.model.Employee;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    //ArrayList<Employee> employees = new ArrayList<>(); //demo
    MyArrayAdapter myArrayAdapter;
    ImageButton btnDelete;
    Button btnCreate;
    TextView edtId, edtName;
    RadioButton rbMale, rbFemale;
    public boolean gender = true;
    public static ArrayList list;

    SQLiteDatabase myDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        btnDelete = findViewById(R.id.btnDelete);
        btnCreate = findViewById(R.id.btnCreate);

        lv = findViewById(R.id.lv);
        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, list);
        lv.setAdapter(myArrayAdapter);

        // Create DataBase;
        myDataBase = openOrCreateDatabase("final.db", MODE_PRIVATE, null);
        // Create Table;
        try {
            String sql = "CREATE TABLE tblfinal(id Text primary key, gender INTEGER, name TEXT)";
            myDataBase.execSQL(sql);
        }catch (Exception e){
            Log.e("Error", "Table is exist!!!");
        }

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtId.getText().toString();
                if (rbMale.isChecked()){
                    gender = true;
                }else {
                    gender = false;
                }
                String name = edtName.getText().toString();
                ContentValues myValue = new ContentValues();
                myValue.put("id", id);        // "tên trường"; String;
                myValue.put("gender", gender);
                myValue.put("name", name);

                String messenger = "";
                if(myDataBase.insert("tblfinal", null, myValue) == -1){
                    messenger = "Fail to Insert Record!!!";
                }else {
                    messenger = "Insert record Sucessfully!!!";
                }
                Toast.makeText(MainActivity.this, messenger, Toast.LENGTH_SHORT).show();

                list.clear(); // xóa dữ liệu cũ trên listView
                Cursor cursor = myDataBase.query("tblfinal", null, null, null, null, null, null);
                cursor.moveToNext();
                String data = "";
                while (cursor.isAfterLast() == false){
                    data = cursor.getString(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2); // sai
                    cursor.moveToNext();    // Di chuyển đến bảng ghi kế tiếp
                    // myList.add(data);
                    list.add(data);
                }
                cursor.close();;
                myArrayAdapter.notifyDataSetChanged();

            }
        });

    }
}