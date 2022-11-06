package com.example.testcustomlistviewnangcao;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class myArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int idLayout;
    ArrayList<Phone> myList;
    // Tạo constructor để MainActivity gọi đến và truyền các tham số vào
    public myArrayAdapter( Activity context, int idLayout, ArrayList<Phone> myList) {
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
        Phone myPhone = myList.get(position);
        //Khai báo, tham chiếu Id và hiển thị ảnh lên ImageView
        ImageView img_phone = convertView.findViewById(R.id.imgPhone);
        img_phone.setImageResource(myPhone.getImg());
        // Khai báo, ánh xạ id và hiển thị dữ liệu tên điện thoại
        TextView txt_phone = convertView.findViewById(R.id.txt_phone);
        txt_phone.setText(myPhone.getName());
        return convertView;
    }
}
