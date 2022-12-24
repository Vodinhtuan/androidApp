package com.example.tienngoc_quanlynhanvien;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.tienngoc_quanlynhanvien.adapter.AdapterNhanVien;
import com.example.tienngoc_quanlynhanvien.model.NhanVien;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvnv;
    ArrayList<NhanVien> dsnv = new ArrayList<>();
    AdapterNhanVien adapterNhanVien;
    ImageButton btnxoa;
    Button btnnhap;
    EditText txtmanv,txttennv;
    RadioButton rbNu,rbNam;
    boolean gioitinh=true;
    public static ArrayList<Integer> vitri= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addcontrols();
        addEvent();
    }

    private void addEvent() {
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!vitri.isEmpty()){
                    for(int k:vitri){
                        dsnv.remove(k);
                    }
                    vitri.clear();
                    adapterNhanVien.notifyDataSetChanged();
                }else{
                    Toast.makeText(MainActivity.this,"Chưa chọn nhân viên.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(rbNam.isChecked()){
            gioitinh=true;
        }else{
            gioitinh=false;
        }

        btnnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dsnv.add(new NhanVien(txtmanv.getText().toString(),txttennv.getText().toString(),gioitinh));
                adapterNhanVien = new AdapterNhanVien(MainActivity.this,R.layout.layout_item,dsnv);
                lvnv.setAdapter(adapterNhanVien);
            }
        });
    }

    private void addcontrols() {
        txtmanv=findViewById(R.id.edtmanv);
        txttennv=findViewById(R.id.edttennv);
        rbNam = findViewById(R.id.rbnam);
        rbNu = findViewById(R.id.rbnu);
        btnxoa = findViewById(R.id.btnxoa);
        btnnhap = findViewById(R.id.btnnhap);
        lvnv=findViewById(R.id.lvnhanvien);
        dsnv.add(new NhanVien("ma1","Sơn Tùng",true));
        dsnv.add(new NhanVien("ma2","Đông Nhi",false));
        dsnv.add(new NhanVien("ma3","MoNo",true));
        dsnv.add(new NhanVien("ma4","Bảo Anh",false));
        dsnv.add(new NhanVien("ma5","Tăng Duy Tân",true));
        adapterNhanVien = new AdapterNhanVien(MainActivity.this,R.layout.layout_item,dsnv);
        lvnv.setAdapter(adapterNhanVien);
    }
}