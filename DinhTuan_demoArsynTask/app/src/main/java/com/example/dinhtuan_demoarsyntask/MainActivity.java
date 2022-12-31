package com.example.dinhtuan_demoarsyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dinhtuan_demoarsyntask.asynctask.MyAsyncTask;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    // Khai báo MyAsyncTask
    MyAsyncTask mytt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.button);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doStart();
            }
        });
    }
    private void doStart(){
        // Truyền this (chính là MainActivity hiện tại) qua background Thread
        mytt = new MyAsyncTask(this);
        /*Kích hoạt tiến trình
        Khi gọi hàm này thì onPreExcute của mytt sẽ thực thi trước */
        mytt.execute();

    }
}