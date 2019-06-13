package com.example.yt.myapplication.server;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.yt.myapplication.entitys.MusicSong_bean;
import com.example.yt.myapplication.ui.activitys.MusicWebMusic;
import com.example.yt.myapplication.until.MusicServerListining;

public class MusicServer extends Service {
    MediaPlayer mediaPlayer;
    MusicSong_bean.ListbeanBean listbeanBean;
    MusicServerListining musicServerListining;

    public void setMusicServerListining(MusicServerListining musicServerListining) {
        this.musicServerListining = musicServerListining;
    }

    public MusicServer() {

    }
    String mp3 ;
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Bundle music = intent.getBundleExtra("music");
        listbeanBean=(MusicSong_bean.ListbeanBean) music.getSerializable("mp3");
        try {

          mediaPlayer=MediaPlayer.create(this, Uri.parse(listbeanBean.getMusicurl()));
          //总时间
          int duration = mediaPlayer.getDuration();
          mediaPlayer.setLooping(false);
          mediaPlayer.start();
          mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
              @Override
              public void onPrepared(MediaPlayer mp) {
                  if(musicServerListining!=null){
                      musicServerListining.Startinfo(mediaPlayer,listbeanBean.getSonname(),duration);
                  }

              }
          });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if(musicServerListining!=null){
                        musicServerListining.Stopinfo(mediaPlayer,listbeanBean.getSonname());
                    }
                }
            });
      }catch (Exception e){
        Intent dialogIntent = new Intent(getBaseContext(), MusicWebMusic.class);
          dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          dialogIntent.putExtra("musicurl",listbeanBean.getSonid());
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
