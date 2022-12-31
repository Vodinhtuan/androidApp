package com.example.dinhtuan_demoarsyntask.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dinhtuan_demoarsyntask.R;

public class MyAsyncTask extends AsyncTask<Void, Integer, Void> {
    // Khai báo Activity để lưu trữ context của MainActivity
    Activity contextCha;
    // constructor này được truyền vào là MainActivity;
    public MyAsyncTask(Activity ctx){
        contextCha = ctx;
    }
    // Hàm này sẽ được thực hiện đầu tiên

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(contextCha, "conPreExecute!!!", Toast.LENGTH_LONG).show();
    }
    // Sau đó hàm doInBackground sẽ làm việc

    @Override
    protected Void doInBackground(Void... voids) {
        for (int i = 0; i<=100; i++){
            // Nghỉ 100 milisecond thì tiến hành update UI
            SystemClock.sleep(100);
            // Khi gọi hàm này thì onProgresUpdate sẽ thực thi
            publishProgress(i);
        }
        return null;
    }
    // Ta cập nhật giao diện trong hàm này

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        // Thông qua contextCha để lấy được control trong MainActivity
        ProgressBar paCha = (ProgressBar)
                contextCha.findViewById(R.id.progressBar);
        // Vì publishProgress chỉ truyền 1 đối số nên mảng values chỉ có 1 phần tử
        int giatri = values[0];
        // Tăng giá trị của Progressbar lên
        paCha.setProgress(giatri);
        // Đồng thời hiển thị giá trị là % lên TextView
        TextView txtmsg = (TextView) contextCha.findViewById(R.id.textView1);
        txtmsg.setText(giatri + "%");
    }
    // Sau khi tiến trình thực hiện xong thì hàm này xảy ra

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        Toast.makeText(contextCha, "Update successful !!! <3", Toast.LENGTH_LONG).show();
    }
}
