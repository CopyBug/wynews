package com.example.yt.myapplication.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ScrollView;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.adapters.VideoApater;
import com.example.yt.myapplication.entitys.Video_Bean;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends BaseFragment {
    private ListView listview;
    private List<Video_Bean> sp = new ArrayList<>();
    private VideoApater videoApater;
    private ScrollView fragment_video_scro;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = FindView(inflater, container, R.layout.fragment_video);
        activity = getActivity();
        initView(view);
        return view;
    }

    private void initView(View view) {
        listview = (ListView) view.findViewById(R.id.listview);
        fragment_video_scro = (ScrollView) view.findViewById(R.id.fragment_video_scro);
        initSpAadpter();
        fragment_video_scro.smoothScrollTo(0, 0);
    }

    private void initSpAadpter() {
        videoApater = new VideoApater(sp, activity);
        listview.setAdapter(videoApater);
        AddShiping("https://music.163.com/video?id=58D10B3BF3CD5882987BBE3FE24066AE&userid=1878422880", "林肯公园in the end大合唱", "http://img.takungpao.com/2017/0803/20170803031552717.jpg");
        AddShiping("https://music.163.com/video?id=06914A6A889D36D776167A53EFEDA708&userid=1878422880", "英雄联盟全球总决赛主题曲现场版", "http://img5.imgtn.bdimg.com/it/u=3319206768,881517281&fm=26&gp=0.jpg");
        AddShiping("https://music.163.com/video?id=06914A6A889D36D776167A53EFEDA708&userid=1878422880", "英雄联盟全球总决赛主题曲现场版", "http://img5.imgtn.bdimg.com/it/u=3319206768,881517281&fm=26&gp=0.jpg");
        AddShiping("https://music.163.com/video?id=06914A6A889D36D776167A53EFEDA708&userid=1878422880", "英雄联盟全球总决赛主题曲现场版", "http://img5.imgtn.bdimg.com/it/u=3319206768,881517281&fm=26&gp=0.jpg");
        AddShiping("https://music.163.com/video?id=06914A6A889D36D776167A53EFEDA708&userid=1878422880", "英雄联盟全球总决赛主题曲现场版", "http://img5.imgtn.bdimg.com/it/u=3319206768,881517281&fm=26&gp=0.jpg");
        AddShiping("https://music.163.com/video?id=06914A6A889D36D776167A53EFEDA708&userid=1878422880", "英雄联盟全球总决赛主题曲现场版", "http://img5.imgtn.bdimg.com/it/u=3319206768,881517281&fm=26&gp=0.jpg");

    }

    public void AddShiping(String videourl, String tv, String imgurl) {
        Video_Bean videoBean = new Video_Bean(videourl, imgurl, tv);
        sp.add(videoBean);
        videoApater.notifyDataSetChanged();

    }
}