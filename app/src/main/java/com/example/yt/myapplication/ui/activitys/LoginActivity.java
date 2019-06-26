package com.example.yt.myapplication.ui.activitys;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.databinding.ActivityLoginBinding;
import com.example.yt.myapplication.entitys.Userinfo;
import com.example.yt.myapplication.until.OftenUntil;

public class LoginActivity extends AppCompatActivity {
    public static Userinfo userinfo=new Userinfo();
    ActivityLoginBinding activityLoginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding=DataBindingUtil.setContentView(this,R.layout.activity_login);

        activityLoginBinding.setUserinfo(userinfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityLoginBinding.setUserinfo(userinfo);
    }

    public void Statrfelling(View view){
        finish();
    }
    public void StartLogin(View view){
        OftenUntil.JumpActivity(this,StartLoginActivity.class);
    }
}
