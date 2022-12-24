package com.example.vodinhtuan_kt_lan2;

import androidx.appcompat.app.AppCompatActivity;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();

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
                edtId.
            }
        });
    }
}