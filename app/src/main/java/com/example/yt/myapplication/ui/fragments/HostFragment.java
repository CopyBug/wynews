package com.example.yt.myapplication.ui.fragments;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yt.myapplication.R;
import com.example.yt.myapplication.adapters.HostGvAdapter;
import com.example.yt.myapplication.entitys.TuijianGedan_bean;
import com.example.yt.myapplication.views.MessureGridview;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class HostFragment extends BaseFragment implements View.OnClickListener {


    private Banner host_bvp;
    private List<String> imgurl;
    private LinearLayout menu1;
    private TextView host_cal;
    private LinearLayout menu2;
    private LinearLayout menu3;
    private LinearLayout menu4;
    private LinearLayout menu5;
    private MessureGridview host_gv;
    private List<TuijianGedan_bean> gvitem;
    private ImageView test;
    private ScrollView host_scroll;
    private Button guanchan;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        gvitem = new ArrayList<>();
        View view = FindView(inflater, container, R.layout.fragment_host);
        initView(view);
        return view;
    }

    private void initView(View view) {
        host_bvp = view.findViewById(R.id.host_bvp);
        initBanner();
        menu1 = (LinearLayout) view.findViewById(R.id.menu1);
        host_cal = (TextView) view.findViewById(R.id.host_cal);
        menu2 = (LinearLayout) view.findViewById(R.id.menu2);
        menu3 = (LinearLayout) view.findViewById(R.id.menu3);
        menu4 = (LinearLayout) view.findViewById(R.id.menu4);
        menu5 = (LinearLayout) view.findViewById(R.id.menu5);
        host_gv = (MessureGridview) view.findViewById(R.id.host_gv);
        host_scroll = (ScrollView) view.findViewById(R.id.host_scroll);
        host_scroll.smoothScrollTo(0, 0);
        GetToday();
        initadapter();


        guanchan = (Button) view.findViewById(R.id.guanchan);
        guanchan.setOnClickListener(this);
    }


    private void initadapter() {
        AddTuijian("http://p1.music.126.net/pWfosczO-H1_N5oWC5veYQ==/109951164133840480.jpg?param=140y140", "100味华语女声：经得住时间的美 ", "146万");
        AddTuijian("http://p1.music.126.net/CctKieGt_Se7r9Fi9Rt3RA==/109951164109064827.jpg?param=140y140", "Noise Pop丨迷幻噪音摇滚 ", "28万");
        AddTuijian("http://p1.music.126.net/mbWmuCkUPmGQyVPPi6K6Ag==/109951163046516516.jpg?param=140y140", "专供｜T台魅影，秀场律动。 ", "65万");
        AddTuijian("http://p1.music.126.net/sFZutBEY8GiP2_3Q0QVldA==/109951164133640069.jpg?param=140y140", " 男人爱不爱你，谈谈钱就懂了 ", "65");
        AddTuijian("http://p2.music.126.net/wc_4zG3XMFlku4AdeUHg1g==/109951163561148208.jpg?param=140y140", " 「神仙翻唱」好听的翻唱Cover集 ", "5434万");
        AddTuijian("http://p2.music.126.net/lmJ88VqiwzYNHEzoswfFZQ==/109951164123615856.jpg?param=140y140", " 分手后，你偷看过前任的微博吗？", "5434万");
        AddTuijian("http://p2.music.126.net/D9i1SyfZQDUefFC4YXB1qg==/7820826208648666.jpg?param=140y140", "地球最减压音乐top10", "63万");
        AddTuijian("http://p2.music.126.net/eyscJboRyhg8Bn8ayyrNTw==/109951163685921201.jpg?param=140y140", "黄昏", "169万");
        HostGvAdapter hostGvAdapter = new HostGvAdapter(gvitem, activity);
        host_gv.setAdapter(hostGvAdapter);
    }

    public void AddTuijian(String imgurl, String msg, String bofan) {
        TuijianGedan_bean tuijianGedan_bean = new TuijianGedan_bean(imgurl, msg, bofan);
        gvitem.add(tuijianGedan_bean);
    }
/*获取当天信息*/
    public void GetToday() {
        Calendar calendar = Calendar.getInstance();
        int i = calendar.get(Calendar.DAY_OF_MONTH);
        host_cal.setText(i + "");
    }
/*轮播图*/
    private void initBanner() {
        imgurl = new ArrayList<>();
        imgurl.add("http://p1.music.126.net/v4tyuXfAVtIdXIxfb2gEIQ==/109951164137211940.jpg");
        imgurl.add("http://p1.music.126.net/QqW44lj6Mu_UfEoa8_-7jw==/109951164136559555.jpg");
        imgurl.add("http://p1.music.126.net/db2wx3YikiIgLKA_u_LmVg==/109951164136548362.jpg");
        imgurl.add("http://p1.music.126.net/rqD3v-74jAkxLzwz22P0zA==/109951164137397341.jpg");
        host_bvp.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        host_bvp.setBannerAnimation(Transformer.Default);
        host_bvp.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setPadding(10, 0, 10, 0);

                Glide.with(context).load(path).into(imageView);
            }
        });
        host_bvp.setImages(imgurl);
        host_bvp.isAutoPlay(true);
        host_bvp.setDelayTime(3000);
        host_bvp.setIndicatorGravity(BannerConfig.CENTER);
        host_bvp.start();
    }
/*广场popwindow*/
    public void songsSquare() {
        View view1 = LayoutInflater.from(activity).inflate(R.layout.fragment_host_poplayout, null, false);
        PopupWindow popupWindow = new PopupWindow(activity);
        popupWindow.setContentView(view1);

        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(false);
        ColorDrawable cd = new ColorDrawable(0xffffff);
        popupWindow.setBackgroundDrawable(cd);

      popupWindow.showAsDropDown(guanchan);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.guanchan:
                songsSquare();
                break;
        }
    }
}
