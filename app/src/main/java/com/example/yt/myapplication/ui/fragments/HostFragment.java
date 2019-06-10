package com.example.yt.myapplication.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yt.myapplication.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class HostFragment extends BaseFragment {


    private Banner host_bvp;
    private List<String> imgurl;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        View view = FindView(inflater, container, R.layout.fragment_host);
        initView(view);
        return view;
    }
    private void initView(View view) {
        host_bvp =  view.findViewById(R.id.host_bvp);
        initBanner();
    }

    private void initBanner() {
        imgurl=new ArrayList<>();
        imgurl.add("http://p1.music.126.net/v4tyuXfAVtIdXIxfb2gEIQ==/109951164137211940.jpg");
        imgurl.add("http://p1.music.126.net/QqW44lj6Mu_UfEoa8_-7jw==/109951164136559555.jpg");
        imgurl.add("http://p1.music.126.net/db2wx3YikiIgLKA_u_LmVg==/109951164136548362.jpg");
        imgurl.add("http://p1.music.126.net/rqD3v-74jAkxLzwz22P0zA==/109951164137397341.jpg");
        host_bvp.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        host_bvp.setBannerAnimation(Transformer.Default);

        host_bvp.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setPadding(10,0,10,0);

                Glide.with(context).load(path).into(imageView);
            }
        });
        host_bvp.setImages(imgurl);
        host_bvp.isAutoPlay(true);
        host_bvp.setDelayTime(3000);
        host_bvp.setIndicatorGravity(BannerConfig.CENTER);
        host_bvp.start();
    }
}
