package com.example.vodinhtuan_finalproject.adapter;

import android.app.Activity;
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

import com.example.vodinhtuan_finalproject.MainActivity;
import com.example.vodinhtuan_finalproject.R;
import com.example.vodinhtuan_finalproject.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<Employee> {
    Activity context;
    int idLayout;
    List<Employee> employees;
    // create contructor for MainActivity

        public MyArrayAdapter(Activity context, int idLayout, List<Employee> employees) {
        super(context, idLayout, employees);
        this.context = context;
        this.idLayout = idLayout;
        this.employees = employees;
    }
    // Gọi hàm getView để tiến hành sắp xếp dữ liệu


    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Tạo đế để chứa Layout
        LayoutInflater inflater = LayoutInflater.from(context);
        // Đặt IdLayout để tạo thành View
         convertView = inflater.inflate(idLayout, parent, false);
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
                    MainActivity.list.add(String.valueOf(position));
                }
            }
        });
        return convertView;
    }

}

