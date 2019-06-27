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
   public static MusicServerListining musicServerListining;

    public static void setMusicServerListining(MusicServerListining newmusicServerListining) {
        musicServerListining=newmusicServerListining;
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
                      musicServerListining.Startinfo(mp,listbeanBean.getSonname(),duration);
                  }

              }
          });
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    if(musicServerListining!=null){
                        musicServerListining.Stopinfo(mp,listbeanBean.getSonname());
                    }
                }
            });
      }catch (Exception e){
        Intent dialogIntent = new Intent(getBaseContext(), MusicWebMusic.class);
          dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
          dialogIntent.putExtra("musicurl","https://music.163.com/#/song?id="+listbeanBean.getSonid());
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
