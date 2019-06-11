package com.example.yt.myapplication.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.yt.myapplication.R;

public class VideoFragment extends BaseFragment {
    private ListView listview;

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
}
