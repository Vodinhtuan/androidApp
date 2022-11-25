package com.example.dinhtuan_ss13_gridview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinhtuan_ss13_gridview.model.Image;

import java.util.ArrayList;
import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<Image> {
    Activity context = null;
    ArrayList<Image> myArray = null;
    int LayoutId;
    // Tạo constructor để MainActivity gọi đến và truyền các tham số vào


    public MyArrayAdapter(Activity context, int idLayout, ArrayList<Image> myList) {
        super(context, idLayout, myList);
        this.context = context;
        this.LayoutId = idLayout;
        this.myArray = myList;
    }

    // gọi hàm getView để tiến hành sắp xếp và hiển thị dữ liệu
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId, null);
        final Image myimage = myArray.get(position);
//dòng lệnh lấy ImageView ra để hiển thị hình ảnh
        final ImageView imgitem =
                (ImageView)convertView.findViewById(R.id.imageView1);
        imgitem.setImageResource(myimage.getImg());
//dòng lệnh lấy TextView ra để hiển thị tên Ảnh
        final TextView myname = (TextView)convertView.findViewById(R.id.textView1);
        myname.setText(myimage.getName());
        return convertView;
    }
}

