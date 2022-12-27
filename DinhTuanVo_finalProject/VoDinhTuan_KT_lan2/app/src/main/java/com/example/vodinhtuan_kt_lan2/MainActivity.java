package com.example.vodinhtuan_kt_lan2;

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

import com.example.vodinhtuan_kt_lan2.adapter.MyArrayAdapter;
import com.example.vodinhtuan_kt_lan2.model.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<Employee> employees = new ArrayList<>(); //demo
    MyArrayAdapter myArrayAdapter;
    ImageButton btnDelete;
    Button btnCreate;
    TextView edtId, edtName;
    RadioButton rbMale, rbFemale;
    public boolean gender = true;
    public static ArrayList<String> list = new ArrayList<String>();

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

        //addControls();
        //addEvent();

        // Create DataBase;
        /*myDataBase = openOrCreateDatabase(DATABASE_NAME, MODE_PRIVATE, null);*/
        // Create Table;
        try {
            String sql = "CREATE TABLE tblEmployee(id Text primary key, gender INTEGER, name TEXT)";
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
                if(myDataBase.insert("tblEmployee", null, myValue) == -1){
                    messenger = "Fail to Insert Record!!!";
                }else {
                    messenger = "Insert record Sucessfully!!!";
                }
                Toast.makeText(MainActivity.this, messenger, Toast.LENGTH_SHORT).show();
            }

        });

        list.clear();
        Cursor cursor = myDataBase.query("tblEmployee", null, null, null, null, null, null);
        cursor.moveToNext();
        String data = "";
        while (cursor.isAfterLast() == false){
            data = cursor.getString(0) + " - " + cursor.getString(1) + " - " + cursor.getString(2);
            cursor.moveToNext();    // Di chuyển đến bảng ghi kế tiếp
            list.add(data);
        }
        cursor.close();;
        myArrayAdapter.notifyDataSetChanged();

    }





    // cách 2
    /*private void processCopy() {
        File dbFile = getDatabasePath(DATABASE_NAME);
        if (!dbFile.exists())
        {
            try{CopyDataBaseFromAsset();
                Toast.makeText(this, "Copying sucess from Assets folder", Toast.LENGTH_LONG).show();
            }
            catch (Exception e){
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }

    }

    private String getDatabasePath() {
        return getApplicationInfo().dataDir + DB_PATH_SUFFIX+ DATABASE_NAME;
    }

    public void CopyDataBaseFromAsset() {
        try {
            InputStream myInput;
            myInput = getAssets().open(DATABASE_NAME);

            String outFileName = getDatabasePath();

            File f = new File(getApplicationInfo().dataDir + DB_PATH_SUFFIX);
            if (!f.exists())
                f.mkdir();

            OutputStream myOutput = new FileOutputStream(outFileName);

            int size = myInput.available();
            byte[] buffer = new byte[size];
            myInput.read(buffer);
            myOutput.write(buffer);

            myOutput.flush();
            myOutput.close();
            myInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addControls(){
        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        btnDelete = findViewById(R.id.btnDelete);
        btnCreate = findViewById(R.id.btnCreate);
        lv = findViewById(R.id.lv);
        processCopy();
        database = openOrCreateDatabase(DATABASE_NAME,MODE_PRIVATE, null);

        *//*employees.add(new Employee("SS01", true, "DinhTuan"));
        employees.add(new Employee("SS02", false, "Female"));
        employees.add(new Employee("SS03", true, "DinhTuan"));
        employees.add(new Employee("SS04", false, "Female"));*//*

        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item,employees);
        lv.setAdapter(myArrayAdapter);
        Cursor c = database.query("employee",null,null,null,null,null,null);
        c.moveToFirst();
        String data ="";
        while (c.isAfterLast() == false)
        {
            data = c.getString(0)+"-"+c.getString(1)+"-"+c.getString(2);
            list.add(data);
            c.moveToNext();
        }
        c.close();
        myArrayAdapter.notifyDataSetChanged();
    }


    private void addEvent(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!list.isEmpty()){
                    for (String k:list){
                        employees.remove(k);
                    }
                    list.clear();
                    myArrayAdapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(MainActivity.this, "Please select at least 1 employee!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        if (rbMale.isChecked()){
            gender = true;
        }else {
            gender = false;
        }


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                employees.add(new Employee(edtId.getText().toString(), gender, edtName.getText().toString()));
                myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item, employees);
                lv.setAdapter(myArrayAdapter);
                edtId.setText("");
                edtName.setText("");
            }
        });
    }*/
}