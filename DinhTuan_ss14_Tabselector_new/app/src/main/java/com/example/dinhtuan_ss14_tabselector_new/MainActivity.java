package com.example.dinhtuan_ss14_tabselector_new;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edta, edtb;
    Button btntong;
    TabHost mytab;
    // Khai báo ListView
    ListView lv;
    ArrayList<String> myList;
    ArrayAdapter<String> myadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
    }

    private void addEvent() {
        btntong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(edta.getText().toString());
                int b = Integer.parseInt(edtb.getText().toString());
                int c = a + b;
                myList.add(a + " + " + b + " = " + c);  //Thêm dữ liệu vào cho mảng
                myadapter.notifyDataSetChanged();   // Cập nhật lại Adapter
            }
        });
    }

    private void addControl() {
        // Ánh xạ id
        edta = findViewById(R.id.edta);
        edtb = findViewById(R.id.edtb);
        btntong = findViewById(R.id.btntong);

        // Xử lý listView
        lv.findViewById(R.id.lv);
        // Tạo mảng
        myList = new ArrayList<>();
        // Tạo Adapter
        myadapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,myList);
        lv.setAdapter(myadapter);
        // Xử lý TabHost
        mytab = findViewById(R.id.mytab);
        mytab.setup();
        // Khai báo các Tab con (TabSpet)
        TabHost.TabSpec spec1, spec2;

        // Ứng với mỗi Tab con, chúng ta thực hiện 4 công việc
        // Tab 1
        spec1 = mytab.newTabSpec("t1"); // Tạo mới Tab
        spec1.setContent(R.id.tab1);    // Tham chiếu id cho Tab 1
        spec1.setIndicator("", getResources().getDrawable(R.drawable.cong));
        mytab.addTab(spec1);    // Thêm Tab 1 vào tag chính

        // Tab 1
        spec2 = mytab.newTabSpec("t2"); // Tạo mới Tab
        spec2.setContent(R.id.tab2);    // Tham chiếu id cho Tab 2
        spec2.setIndicator("", getResources().getDrawable(R.drawable.lichsu));
        mytab.addTab(spec2);    // Thêm Tab 1 vào tag chính
    }
}