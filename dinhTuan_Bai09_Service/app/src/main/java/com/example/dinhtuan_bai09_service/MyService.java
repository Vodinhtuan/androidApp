package com.example.dinhtuan_bai09_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyService extends Service {
    // Khai báo đối tượng mà Service quản lý
    MediaPlayer mediaPlayer;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    // Gọi hàm onCreate để tạo đối tượng mà Service quản lý

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(MyService.this,R.raw.trentinhbanduoitinhyeu);
        // lặp đi lặp lại bài hát.
        mediaPlayer.setLooping(true);
    }

    // Gọi hàm onStarCommand để khởi chạy đối tượng mà Service quản lý
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }else {
            mediaPlayer.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

     // Gọi hàm onDestroy để dừng đối tương mà Service quản lý
    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }
}