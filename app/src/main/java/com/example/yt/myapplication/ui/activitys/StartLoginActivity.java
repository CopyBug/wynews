package com.example.yt.myapplication.ui.activitys;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.databinding.ActivityStartLoginBinding;
import com.example.yt.myapplication.entitys.Successinfo;
import com.example.yt.myapplication.entitys.Userinfo;
import com.example.yt.myapplication.until.newUntil.HttpUtil;
import com.example.yt.myapplication.until.newUntil.NetworkListning;
import com.google.gson.Gson;

public class StartLoginActivity extends AppCompatActivity {
    Toolbar toolbar;
    ActivityStartLoginBinding activityStartLoginBinding;
    private EditText xuehao;
    private EditText sfz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        activityStartLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_start_login);
        activityStartLoginBinding.setUserinfo(new Userinfo());
        toolbar = findViewById(R.id.toolbar);
        initView();

    }

    public void Returnactivity(View view) {
        finish();
    }

    public void startfelling(View view) {
        String s1 = xuehao.getText() + "";
        String s2 = sfz.getText() + "";
        //activityStartLoginBinding.setUserinfo(userinfo22);
       // Userinfo userinfo = activityStartLoginBinding.getUserinfo();
        if (s1.equals("")  ||s2 .equals("") ) {
            Toast.makeText(this, "请不要留空", Toast.LENGTH_SHORT).show();
        } else {
            String s ="{\"student_id\":\""+s1+"\",\"id_card\":\""+s2+"\"}";
            HttpUtil.asyPostRequset("http://121.9.253.237:8888/StudentP/Slogin", s, Successinfo.class, false, new NetworkListning<Successinfo>() {
                @Override
                public void resultSuccess(Successinfo successinfo) {
                    if (successinfo != null) {
                        if (successinfo.isResult()) {
                            LoginActivity.userinfo.setMsg("已经登录");
                            LoginActivity.userinfo.setStudent_id(s1);
                           runOnUiThread(new Runnable() {
                               @Override
                               public void run() {
                                   Toast.makeText(StartLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                                   onBackPressed();
                               }
                           });
                        }else{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(StartLoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(StartLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }

                @Override
                public void resultFail(String error) {
                    super.resultFail(error);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(StartLoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });
        }

    }

    private void initView() {
        xuehao = (EditText) findViewById(R.id.xuehao);
        sfz = (EditText) findViewById(R.id.sfz);
    }

    private void submit() {
        // validate
        String xuehaoString = xuehao.getText().toString().trim();
        if (TextUtils.isEmpty(xuehaoString)) {
            Toast.makeText(this, "请输入学号", Toast.LENGTH_SHORT).show();
            return;
        }

        String sfzString = sfz.getText().toString().trim();
        if (TextUtils.isEmpty(sfzString)) {
            Toast.makeText(this, "请输入身份证", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
