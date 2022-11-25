package com.example.dinhtuan_bai13_listviewnangcao3_danhba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinhtuan_bai13_listviewnangcao3_danhba.model.Person;
import java.util.ArrayList;

public class myArrayAdapter extends ArrayAdapter<Person> {
    Activity context;
    int idLayout;
    ArrayList<Person> myList;
    // Tạo constructor để MainActivity gọi đến và truyền các tham số vào
    public myArrayAdapter(Activity context, int idLayout, ArrayList<Person> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.idLayout = idLayout;
        this.myList = myList;
    }

    // gọi hàm getView để tiến hành sắp xếp và hiển thị dữ liệu
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Tạo để chứa layout
        LayoutInflater myflater = context.getLayoutInflater();
        // Đặt idLayout lên để tạo thành View
        convertView = myflater.inflate(idLayout,null);
        // lấy 1 phần tử trong mảng
        Person person = myList.get(position);

        //Khai báo, tham chiếu Id và hiển thị namePhone lên ImageView
        TextView txt_name = convertView.findViewById(R.id.txtName);
        txt_name.setText(person.getName());

        // Khai báo, ánh xạ id và hiển thị dữ liệu số điện thoại
        TextView txt_phone = convertView.findViewById(R.id.txtPhone);
        txt_phone.setText(person.getPhone());

        return convertView;
    }
}
