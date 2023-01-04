package com.example.vodinhtuan_karaokefinalproject.adapter;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vodinhtuan_karaokefinalproject.MainActivity;
import com.example.vodinhtuan_karaokefinalproject.R;
import com.example.vodinhtuan_karaokefinalproject.model.Item;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Item> {
    Activity context = null;
    ArrayList<Item>myArray = null;
    int LayoutId;
    public myarrayAdapter(Activity context, int LayoutId, ArrayList<Item> arr) {
        super(context, LayoutId,arr);
// TODO Auto-generated constructor stub
        this.context = context;
        this.LayoutId = LayoutId;
        this.myArray = arr;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
// TODO Auto-generated method stub
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId, null);
        final Item myItem = myArray.get(position);
        final TextView tieude =
                (TextView)convertView.findViewById(R.id.txtTitle);
        tieude.setText(myItem.getTieude());
        final TextView maso =(TextView)convertView.findViewById(R.id.txtCode);
        maso.setText(myItem.getMaso());
        final ImageView btnlike =
                (ImageView)convertView.findViewById(R.id.btnLike);
        final ImageView btnunlike =
                (ImageView)convertView.findViewById(R.id.btnUnlike);
        int thich = myItem.getThich();
//Xử lý hiển thị cho ImageButton btnlike và btnunlikeif (thich==0) {
        btnlike.setVisibility(View.INVISIBLE); //cho ẩn btnlike
        btnunlike.setVisibility(View.VISIBLE); //cho hiển thị btnunlike
    } else {
        btnUnlike.setVisibility(View.INVISIBLE); //cho ẩn btnunlike
        btnLike.setVisibility(View.VISIBLE); //cho hiện btnlike
    }
// Xử lý sự kiện khi click vào ImageButton btnlike và btnunlike
// Cập nhật trạng thái thich vào CSDL; Thiết lập ImageButton cho phù hợp
btnLike.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            ContentValues values = new ContentValues();
            values.put("YEUTHICH", 0);
            MainActivity.database.update("ArirangSongList", values,
                    "MABH=?", new String[]{maso.getText().toString()});
            btnlike.setVisibility(View.INVISIBLE);
            btnunlike.setVisibility(View.VISIBLE);
        }
    });
btnunlike.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            ContentValues values = new ContentValues();
            values.put("YEUTHICH", 1);
            MainActivity.database.update("ArirangSongList", values,
                    "MABH=?", new String[]{maso.getText().toString()});
            btnunlike.setVisibility(View.INVISIBLE);
            btnlike.setVisibility(View.VISIBLE);
        }
    });
//Xử lý sự kiện khi Click vào mỗi dòng tiều đề bài hát trên Listview
//Chuyển Textview tieude và maso sang màu đỏ
//Khai báo Intent, Bundle,lấy maso truyền qua subactivity và gọi activitysub
//(activitysub xây dựng ở bước sau)
            tieude.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
// TODO Auto-generated method stub
            tieude.setTextColor(Color.RED);
            maso.setTextColor(Color.RED);
            Intent intent1 = new Intent(context,activitysub.class);
            Bundle bundle1 = new Bundle();
            bundle1.putString("maso", maso.getText().toString());
            intent1.putExtra("package", bundle1);
            context.startActivity(intent1);
        }
    });
return convertView;
}
}
