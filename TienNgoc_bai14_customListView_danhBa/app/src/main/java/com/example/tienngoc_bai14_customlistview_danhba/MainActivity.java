package com.example.tienngoc_bai14_customlistview_danhba;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tienngoc_bai14_customlistview_danhba.adapter.adaptercostum;
import com.example.tienngoc_bai14_customlistview_danhba.model.Detail;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String [] arrayphone = {"0932588634","0932588635","0932588636","0932588637","0932588638"};
    private String []arrayname = {"1-Nguyễn Văn Nam","2-Trần Văn Tú","3-Nguyễn Thị Lan","4-Nguyễn Kim Ngân","5- Ngô Lê Minh Tâm"};
    private ListView listViewDemo;
    private adaptercostum adapterDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewDemo = (ListView) findViewById(R.id.lv);
        ArrayList<Detail> arrdetail = new ArrayList<Detail>();
        adapterDanhSach = new adaptercostum(MainActivity.this,R.layout.item,arrdetail);
        listViewDemo.setAdapter(adapterDanhSach);
        for (int i = 0; i < arrayname.length; i++) {
            Detail mydetail= new Detail();
            mydetail.setName(arrayname[i]);
            mydetail.setPhone(arrayphone[i]);
            arrdetail.add(mydetail);
            adapterDanhSach.notifyDataSetChanged();
        }
    }
}