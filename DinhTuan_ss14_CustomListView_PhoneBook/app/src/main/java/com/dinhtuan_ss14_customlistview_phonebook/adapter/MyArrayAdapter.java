package com.dinhtuan_ss14_customlistview_phonebook.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dinhtuan_ss14_customlistview_phonebook.model.PhoneBook;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<PhoneBook> {
    Activity context;
    int idLayout;
    ArrayList<PhoneBook> myList;

    // Tạo constructor để MainActivity gọi đến và truyền các tham số vào
    public MyArrayAdapter(Activity context, int idLayout, ArrayList<PhoneBook> myList) {
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
        PhoneBook phoneBook = myList.get(position);

        //Khai báo, tham chiếu Id và hiển thị namePhone lên ImageView
        TextView txt_name = convertView.findViewById(R.id.txtName);
        txt_name.setText(phoneBook.getName());

        // Khai báo, ánh xạ id và hiển thị dữ liệu số điện thoại
        TextView txt_phone = convertView.findViewById(R.id.txtPhone);
        txt_phone.setText(phoneBook.getPhone());

        return convertView;
    }
}
