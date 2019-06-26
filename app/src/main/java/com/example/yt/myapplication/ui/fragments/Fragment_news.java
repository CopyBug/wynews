package com.example.yt.myapplication.ui.fragments;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yt.myapplication.BR;
import com.example.yt.myapplication.R;
import com.example.yt.myapplication.adapters.ActivityMainItemAdapter;
import com.example.yt.myapplication.databinding.ActivityNewsItemBinding;
import com.example.yt.myapplication.databinding.FragmentNewsBinding;
import com.example.yt.myapplication.entitys.JournalismBean;
import com.example.yt.myapplication.until.NetworkListining;
import com.example.yt.myapplication.until.OkhttpUntil;

import java.util.List;

@SuppressLint("ValidFragment")
public class Fragment_news  extends Fragment {
  public static   Activity activity;
    private String type;

    public Fragment_news(String type) {
        this.type = type;
    }

    FragmentNewsBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity=getActivity();
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_news,container,false);
        View root = binding.getRoot();
        Getinit();
        return root;
    }
    public void Getinit(){
        OkhttpUntil.enqueueGetrequest("http://v.juhe.cn/toutiao/index?key=7c0ababdc68c2e18057196fa73881e31&type=" + type,
                JournalismBean.class, new NetworkListining<JournalismBean>() {
                    @Override
                    public void BackResultSuccess(JournalismBean bean, int code) {
                    if(bean!=null){
                       if(bean.getReason().equals("超过每日可允许请求次数!")){
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                AlertDialog alertDialog=new AlertDialog.Builder(activity).setMessage("超过每日可允许请求次数!").show();
                            }
                        });
                       }else{
                           List<JournalismBean.ResultBean.DataBean> data = bean.getResult().getData();
                           ActivityMainItemAdapter activityMainItemAdapter=new ActivityMainItemAdapter(data,activity,R.layout.activity_news_item, BR.news);
                           binding.setAdapters(activityMainItemAdapter);

                       }

                    }
                    }

                    @Override
                    public void BackResultFail(Exception errow) {

                    }

                    @Override
                    public void tostring(String responseString) {

                    }
                });
    }
}
