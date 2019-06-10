package com.example.yt.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.yt.myapplication.adapters.FragmentViewpageAdapter;
import com.example.yt.myapplication.ui.fragments.HostFragment;
import com.example.yt.myapplication.ui.fragments.MyselfFragment;
import com.example.yt.myapplication.ui.fragments.SearchFragment;
import com.example.yt.myapplication.ui.fragments.VideoFragment;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SickMusic extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private CircleImageView imageView;
    private TextView headerUsername;
    private Button headerQiandao;
    private TextView headerLeague;
    private TextView headerMessage;
    private TextView headerUser;
    private TextView headerPifu;
    private TextView headerVoice;

    private List<String> title=new ArrayList<>();
    private List<Fragment> fragments=new ArrayList<>();
    private   NavigationView navigationView ;
  private  Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sick_music);
        initlayout();
    }
    private ViewPager contentVp;


    private TabLayout barTl;



    private void initlayout() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView= (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        imageView = (CircleImageView) findViewById(R.id.imageView);
        headerUsername = (TextView) findViewById(R.id.header_username);
        headerQiandao = (Button) findViewById(R.id.header_qiandao);
        headerLeague = (TextView) findViewById(R.id.header_league);
        headerMessage = (TextView) findViewById(R.id.header_message);
        headerUser = (TextView) findViewById(R.id.header_user);
        headerPifu = (TextView) findViewById(R.id.header_pifu);
        headerVoice = (TextView) findViewById(R.id.header_voice);
        contentVp = (ViewPager) findViewById(R.id.content_vp);
        barTl = (TabLayout) findViewById(R.id.bar_tl);
        AddFragment(new HostFragment(),"主页");
        AddFragment(new MyselfFragment(),"我的");
        AddFragment(new SearchFragment(),"发现");
        AddFragment(new VideoFragment(),"视频");
        FragmentViewpageAdapter fragmentViewpageAdapter=new FragmentViewpageAdapter(getSupportFragmentManager(),fragments,title);
        contentVp.setAdapter(fragmentViewpageAdapter);
        contentVp.setOffscreenPageLimit(5);
        barTl.setupWithViewPager(contentVp);
    }


public void AddFragment(Fragment fragment,String title){
        fragments.add(fragment);
    this.title.add(title);
}
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
