package com.example.yt.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.yt.myapplication.until.OfenUntil;

import java.util.Timer;
import java.util.TimerTask;

public class GuideActivity extends AppCompatActivity {


    private ImageView gudiepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OfenUntil.CancelActionBar(this);
        setContentView(R.layout.activity_guide);
        initView();

        init();

    }
    private void init(){
        Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent=new Intent(GuideActivity.this,SickMusic.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.inmovement,R.anim.movement);
                        finish();
                    }
                });

            }
        };
        timer.schedule(timerTask,1000);
    }

    private void initView() {
        gudiepage = (ImageView) findViewById(R.id.gudiepage);
    }
}
