package com.example.yt.myapplication.server;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.yt.myapplication.ui.activitys.MusicWebMusic;

public class MusicServer extends Service {
    MediaPlayer mediaPlayer;
    public MusicServer() {

    }
    String mp3 ;
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
      try {
          mp3=intent.getStringExtra("mp3");
          mediaPlayer=MediaPlayer.create(this, Uri.parse(mp3));
          //总时间
          int duration = mediaPlayer.getDuration();
          mediaPlayer.setLooping(false);
          mediaPlayer.start();
      }catch (Exception e){
        Intent dialogIntent = new Intent(getBaseContext(), MusicWebMusic.class);
          dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          dialogIntent.putExtra("musicurl",intent.getStringExtra("musicid"));
          getApplication().startActivity(dialogIntent);
      }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }

    @Override
    public void onDestroy() {
        if(mediaPlayer!=null){
            mediaPlayer.stop();
        }
        super.onDestroy();
    }
}
