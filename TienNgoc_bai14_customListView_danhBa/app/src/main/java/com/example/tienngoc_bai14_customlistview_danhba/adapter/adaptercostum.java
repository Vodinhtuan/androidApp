package com.example.tienngoc_bai14_customlistview_danhba.adapter;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import com.example.tienngoc_bai14_customlistview_danhba.R;
import com.example.tienngoc_bai14_customlistview_danhba.model.Detail;

import java.util.ArrayList;

public class adaptercostum extends ArrayAdapter<Detail> {
    Activity context = null;
    ArrayList<Detail> myArray = null;
    int LayoutId;
    public adaptercostum(Activity context, int LayoutId, ArrayList<Detail> arr) {
        super(context, LayoutId, arr);
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
        final Detail mydetail = myArray.get(position);
        final TextView name = (TextView) convertView.findViewById(R.id.txtname);
        name.setText(mydetail.getName());
        final TextView txtphone = (TextView) convertView.findViewById(R.id.txtphone);
        txtphone.setText(mydetail.getPhone());
        final ImageButton imgcall = (ImageButton) convertView.findViewById(R.id.imgcall);
        imgcall.setOnClickListener(new View.OnClickListener() {

            @Override public void onClick(View v) {
// TODO Auto-generated method stub
                Intent callintent = new Intent(Intent.ACTION_CALL);
                callintent.setData(Uri.parse("tel:" + txtphone.getText().toString()));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) !=
                        PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.CALL_PHONE},1);
                    return;
                }
                context.startActivity(callintent);
            }
        });
        final ImageButton imgsms = (ImageButton)convertView.findViewById(R.id.imgsms);
        imgsms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callintent = new Intent(Intent.ACTION_SENDTO,
                        Uri.parse("smsto:"+txtphone.getText().toString()));
                context.startActivity(callintent);
            }
        });
        final ImageButton imgdetail= (ImageButton)convertView.findViewById(R.id.imgdetail);
        return convertView;
    }
}

