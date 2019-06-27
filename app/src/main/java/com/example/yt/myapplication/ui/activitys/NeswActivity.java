package com.example.yt.myapplication.ui.activitys;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.adapters.FragmentViewpageAdapter;
import com.example.yt.myapplication.ui.fragments.Fragment_news;

import java.util.ArrayList;
import java.util.List;

public class NeswActivity extends AppCompatActivity {

    private TabLayout mytab;
    private ViewPager myvp;
    private FragmentViewpageAdapter fragmentViewpageAdapter;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> titles=new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();

    }


    private void initView() {
        mytab = (TabLayout) findViewById(R.id.mytab);
        myvp = (ViewPager) findViewById(R.id.myvp);
        //top(头条，默认),shehui(社会),guonei(国内),guoji(国际),yule(娱乐),tiyu(体育)junshi(军事),keji(科技),caijing(财经),shishang(时尚)
AddFragment(new Fragment_news("top"),"头条");
AddFragment(new Fragment_news("shehui"),"社会");
AddFragment(new Fragment_news("guonei"),"国内");
AddFragment(new Fragment_news("guoji"),"国际");
AddFragment(new Fragment_news("yule"),"娱乐");
AddFragment(new Fragment_news("tiyu"),"体育");
AddFragment(new Fragment_news("junshi"),"军事");
AddFragment(new Fragment_news("keji"),"科技");
AddFragment(new Fragment_news("caijing"),"财经");
AddFragment(new Fragment_news("shishang"),"时尚");
        FragmentViewpageAdapter fragmentViewpageAdapter=new FragmentViewpageAdapter(getSupportFragmentManager(),fragments,titles);
        myvp.setAdapter(fragmentViewpageAdapter);
        mytab.setupWithViewPager(myvp);
        myvp.setOffscreenPageLimit(15);
    }

    public void AddFragment(Fragment fragment, String title){
        fragments.add(fragment);
        titles.add(title);
    }

}
