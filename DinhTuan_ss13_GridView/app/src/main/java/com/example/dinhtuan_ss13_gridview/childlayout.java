package com.example.dinhtuan_ss13_gridview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class childlayout extends AppCompatActivity {
    private Bundle extra;
    TextView txtname2;
    ImageView img2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childlayout);
        txtname2 = (TextView) findViewById(R.id.textView2);
        img2 = (ImageView)findViewById(R.id.imageView2);
        extra = getIntent().getExtras();
        int position = extra.getInt("TITLE");
        txtname2.setText(MainActivity.arrayName[position]);
        img2.setImageResource(MainActivity.imageName[position]);
    }
}