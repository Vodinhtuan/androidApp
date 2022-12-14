package com.example.vodinhtuan_kt_lan2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    ArrayList<Employee> employees = new ArrayList<>();
    MyArrayAdapter myArrayAdapter;
    ImageButton btnDelete;
    Button btnCreate;
    TextView edtId, edtName;
    RadioButton rbMale, rbFemale;
    public boolean gender = true;
    public static ArrayList<Integer> list = new ArrayList<>();

    // Database connect
    String DB_PATH_SUFFIX = "/databases/";
    SQLiteDatabase database=null;
    String DATABASE_NAME="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();

    }

    private void processCopy() {
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
        employees.add(new Employee("SS01", true, "DinhTuan"));
        employees.add(new Employee("SS02", false, "Female"));
        employees.add(new Employee("SS03", true, "DinhTuan"));
        employees.add(new Employee("SS04", false, "Female"));
        myArrayAdapter = new MyArrayAdapter(MainActivity.this, R.layout.layout_item,employees);
        lv.setAdapter(myArrayAdapter);
    }


    private void addEvent(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!list.isEmpty()){
                    for (int k:list){
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
    }
}