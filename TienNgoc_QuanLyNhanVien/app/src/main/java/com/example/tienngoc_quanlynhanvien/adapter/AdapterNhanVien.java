package com.example.tienngoc_quanlynhanvien.adapter;

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
import com.example.tienngoc_quanlynhanvien.MainActivity;
import com.example.tienngoc_quanlynhanvien.R;
import com.example.tienngoc_quanlynhanvien.model.NhanVien;

import java.util.ArrayList;
import java.util.List;

public class AdapterNhanVien extends ArrayAdapter<NhanVien> {
    Activity context;
    int IDlayout;
    ArrayList<NhanVien> nv;
    public AdapterNhanVien(@NonNull Activity context, int IDlayout,  ArrayList<NhanVien> nv) {
        super(context,IDlayout,nv);
        this.nv=nv;
        this.context=context;
        this.IDlayout=IDlayout;
    }

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
