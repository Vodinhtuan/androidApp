package com.example.dinhtuan_vnexpress.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dinhtuan_vnexpress.MainActivity;
import com.example.dinhtuan_vnexpress.R;
import com.example.dinhtuan_vnexpress.model.List;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<List> {
    private Activity context;
    private ArrayList<List> arr;
    private int layoutID;

    public MyArrayAdapter( Activity context, ArrayList<List> arr, int layoutID) {
        super(context, layoutID, arr);
        this.context = context;
        this.arr = arr;
        this.layoutID = layoutID;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView  = inflater.inflate(layoutID, null);
        final List lst = arr.get(position);
        ImageView imgitem = convertView.findViewById(R.id.imgView);
        imgitem.setImageBitmap(lst.getImg());

        TextView txtTitle = convertView.findViewById(R.id.txtTitle);
        txtTitle.setText(lst.getTitle().toString());
        TextView txtInfo = convertView.findViewById(R.id.txtInfo);
        txtInfo.setText(lst.getInfo().toString());
        MainActivity.lv1.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(lst.getLink()));
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
