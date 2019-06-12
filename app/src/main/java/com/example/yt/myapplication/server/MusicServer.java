package com.example.yt.myapplication.server;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;

public class MusicServer extends Service {
    MediaPlayer mediaPlayer;
    public MusicServer() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        String mp3 = intent.getStringExtra("mp3");
        mediaPlayer=MediaPlayer.create(this, Uri.parse(mp3));
        //总时间
        int duration = mediaPlayer.getDuration();
        mediaPlayer.setLooping(false);
        throw new UnsupportedOperationException("Not yet implemented");


    }

    @Override
    public void onCreate() {
        super.onCreate();

    }
}
