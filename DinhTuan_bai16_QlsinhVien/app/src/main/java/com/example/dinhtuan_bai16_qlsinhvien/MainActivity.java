package com.example.dinhtuan_bai16_qlsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnQuery, btnUpdate, btnDelete;
    EditText edtClassId, edtClassName, edtQuantity;
    ListView lv;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;
    SQLiteDatabase myDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDelete = findViewById(R.id.btnDelete);
        btnInsert = findViewById(R.id.btnInsert);
        btnQuery = findViewById(R.id.btnQuery);
        btnUpdate = findViewById(R.id.btnUpdate);
        edtClassId = findViewById(R.id.edtClassId);
        edtClassName = findViewById(R.id.edtclassName);
        edtQuantity = findViewById(R.id.edtQuantity);
        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        lv.setAdapter(myAdapter);

        // Create DataBase;
        myDataBase = openOrCreateDatabase("Student.db", MODE_PRIVATE, null);
        // Create Table;
        try {
            String sql = "CREATE TABLE tblClass(classId Text primary key, className TEXT, quantity INTEGER)";
            myDataBase.execSQL(sql);
        }catch (Exception e){
            Log.e("Error", "Table is exist!!!");
        }
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String classId = edtClassId.getText().toString();
                String className = edtClassName.getText().toString();
                int quantity = Integer.parseInt(edtQuantity.getText().toString());
                ContentValues myValue = new ContentValues();
                myValue.put("classId", classId);
                myValue.put("className", className);
                myValue.put("quantity", quantity);
                String messenger = "";
                if(myDataBase.insert("tblClass", null, myValue) == -1){
                    messenger = "Fail to Insert Record!!!";
                }else {
                    messenger = "Insert record Sucessfully!!!";
                }
                Toast.makeText(MainActivity.this, messenger, Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String classId = edtClassId.getText().toString();
                int n = myDataBase.delete("tblClass", "classId = ?", new String[]{classId});
                String messenger = "";
                if (n == 0){
                    messenger = "No record to Delete!!!";
                }else {
                    messenger = "Record is Delete!!!";
                }
                Toast.makeText(MainActivity.this, messenger, Toast.LENGTH_SHORT).show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int quantity = Integer.parseInt(edtQuantity.getText().toString());
                String className = edtClassName.getText().toString();
                String classId = edtClassId.getText().toString();
                ContentValues myValue = new ContentValues();
                myValue.put("quantity", quantity);
                myValue.put("className", className);
                int n = myDataBase.update("tblClass", myValue, "classId = ? ", new String[]{classId});
                String messenger = "";
                if (n == 0){
                    messenger = "No record to Update!!!";
                }else {
                    messenger = "Record is updated!!!";
                }
                Toast.makeText(MainActivity.this, messenger, Toast.LENGTH_SHORT).show();
            }
        });
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myList.clear();
                Cursor cursor = myDataBase.query("tblClass", null, null, null, null, null, null);
                cursor.moveToNext();
                String data = "";
                while (cursor.isAfterLast() == false){
                    data = cursor.getString(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2);
                    cursor.moveToNext();
                    myList.add(data);
                }
                cursor.close();;
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}