package com.example.yt.myapplication.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.entitys.Video_Bean;

import java.util.List;

public class VideoFragment extends BaseFragment {
    private ListView listview;
    private List<Video_Bean> sp;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = FindView(inflater, container, R.layout.fragment_video);
        initView(view);
        return view;
    }

    private void initView(View view) {
        listview = (ListView) view.findViewById(R.id.listview);
    }
    private void initSpAadpter(){
        AddShiping("https://music.163.com/video?id=58D10B3BF3CD5882987BBE3FE24066AE&userid=1878422880","林肯公园in the end大合唱","http://img.takungpao.com/2017/0803/20170803031552717.jpg");
        AddShiping("https://music.163.com/video?id=06914A6A889D36D776167A53EFEDA708&userid=1878422880","英雄联盟全球总决赛主题曲现场版","http://img5.imgtn.bdimg.com/it/u=3319206768,881517281&fm=26&gp=0.jpg");

    }

    public void AddShiping(String videourl, String tv, String imgurl) {
        Video_Bean videoBean=new Video_Bean(videourl,tv,imgurl);
        sp.add(videoBean);

    }
}