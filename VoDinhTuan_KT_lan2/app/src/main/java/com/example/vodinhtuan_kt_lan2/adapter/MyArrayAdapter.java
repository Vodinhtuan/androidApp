package com.example.vodinhtuan_kt_lan2.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.vodinhtuan_kt_lan2.MainActivity;
import com.example.vodinhtuan_kt_lan2.R;
import com.example.vodinhtuan_kt_lan2.model.Employee;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Employee> {
    Activity context;
    int idLayout;
    ArrayList<Employee> employees;
    // create contructor for MainActivity

    public MyArrayAdapter(Activity context, int idLayout, ArrayList<Employee> employees) {
        super(context, idLayout, employees);
        this.context = context;
        this.idLayout = idLayout;
        this.employees = employees;
    }
    // Gọi hàm getView để tiến hành sắp xếp dữ liệu

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Tạo đế để chứa Layout
        LayoutInflater inflater = context.getLayoutInflater();
        // Đặt IdLayout để tạo thành View
         convertView = inflater.inflate(idLayout, null);
         // Lấy 1 phần tử trong mảng
        Employee employee = employees.get(position);
        // Khai báo, tham chiếu id để hiển thị lên view
        ImageView img_Gender = convertView.findViewById(R.id.img_Gender);
        TextView txt_Name = convertView.findViewById(R.id.txt_Name);
        CheckBox checkBox = convertView.findViewById(R.id.checkBox);
        txt_Name.setText(employee.getId() + " " + employee.getName() + " ");
        if(employee.isGender() == true){
            img_Gender.setImageResource(R.drawable.man);
        }else {
            img_Gender.setImageResource(R.drawable.female);
        }
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (checkBox.isChecked()){
                    MainActivity.list.add(position);
                }
            }
        });
        return convertView;
    }
}
/*
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater=this.context.getLayoutInflater();
        convertView=layoutInflater.inflate(IDlayout,null);
        NhanVien nv = this.nv.get(position);
        ImageView img= convertView.findViewById(R.id.imgnv);
        TextView ten=convertView.findViewById(R.id.txttennv);
        CheckBox chon=convertView.findViewById(R.id.cbchon);

        ten.setText(nv.getIdnv()+" - "+nv.getTennv());

        if(nv.getGioitinh()==true){
            img.setImageResource(R.drawable.male);
        }else{
            img.setImageResource(R.drawable.female);
        }
        chon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chon.isChecked()){
                    MainActivity.vitri.add(position);
                }
            }
        });
        return convertView;
    }
}
ff*/
