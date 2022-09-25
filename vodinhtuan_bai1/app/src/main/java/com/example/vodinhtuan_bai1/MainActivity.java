package com.example.vodinhtuan_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
                protected long backpressTime;
                @Override
                protected void onCreate(Bundle savedInstanceState) {
                    super.onCreate(savedInstanceState);
                    setContentView(R.layout.activity_main);
                }

                @Override
                public void onBackPressed() {
                    if (backpressTime + 2000 > System.currentTimeMillis()){
                        super.onBackPressed();
                        return;
        }else {
            Toast.makeText(this, "Press Back Again To Exit", Toast.LENGTH_SHORT).show();
        }
        backpressTime = System.currentTimeMillis();
    }
}