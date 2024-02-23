package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.widget.Toast;


public class ServiceDemo extends Service {
    private MediaPlayer mediaplayer;

    @Override
    public void onCreate(){
        Toast.makeText(this,"Service is started ",Toast.LENGTH_SHORT);
    }

    @Override
    public int onStartCommand(Intent intent,int flags,int startId){
        mediaplayer = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI);
        mediaplayer.setLooping(true);
        mediaplayer.start();
        Toast.makeText(this,"Service is started ",Toast.LENGTH_SHORT).show();

        return Service.START_STICKY;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mediaplayer.stop();
        Toast.makeText(this,"Service is Stopped ",Toast.LENGTH_SHORT).show();

    }
}
