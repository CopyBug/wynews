package com.example.yt.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class GuideActivity extends AppCompatActivity {


    private ImageView gudiepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        init();

    }
    private void init(){
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(GuideActivity.this,SickMusic.class);
                startActivity(intent);
                GuideActivity.this.finish();
            }
        };
        timer.schedule(timerTask,3000);
    }

    private void initView() {
        gudiepage = (ImageView) findViewById(R.id.gudiepage);
    }
}
