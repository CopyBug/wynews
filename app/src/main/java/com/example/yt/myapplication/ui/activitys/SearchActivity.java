package com.example.yt.myapplication.ui.activitys;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.TouchHelper.SearchTouchHelper;
import com.example.yt.myapplication.adapters.ActivitySearchry_adapter;
import com.example.yt.myapplication.entitys.HistoryRecord_Bean;
import com.example.yt.myapplication.until.OfenUntil;
import com.example.yt.myapplication.views.MessureListview;
import com.example.yt.myapplication.views.MessureRecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private ImageView activity_search_up;
    private EditText activity_search_son;
    private ImageView activity_search_delete;
    private MessureRecyclerView activity_search_recycle;
    private MessureListview activity_search_lv;
    private ActivitySearchry_adapter activitySearchry_adapter;
    private List<HistoryRecord_Bean> historyRecord_beans=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*设置状态栏颜色*/
        OfenUntil.ChangestatusBar(this, "#B7B7B7");
        setContentView(R.layout.activity_search);
        initView();

    }

    private void initView() {
        activity_search_up = (ImageView) findViewById(R.id.activity_search_up);
        activity_search_son = (EditText) findViewById(R.id.activity_search_son);
        activity_search_delete = (ImageView) findViewById(R.id.activity_search_delete);
        activity_search_recycle = (MessureRecyclerView) findViewById(R.id.activity_search_recycle);
        activity_search_lv = (MessureListview) findViewById(R.id.activity_search_lv);
        initson();
        initHistory();
    }
    /*输入文字的监听器*/
    private void initson() {
        activity_search_son.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String s1 = s + "";
                if(!s1.equals("")){
                    activity_search_delete.setVisibility(View.VISIBLE);
                }else{
                    activity_search_delete.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    /*删除文字*/
    public void DeletText(View view){
        activity_search_son.setText("");
    }
    /*结束界面*/
    public void Finish(View view){
        onBackPressed();
    }
    /*初始化历史记录*/
    public void initHistory(){

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        activity_search_recycle.setLayoutManager(layoutManager);
        activitySearchry_adapter=new ActivitySearchry_adapter(historyRecord_beans);
        historyRecord_beans.add(new HistoryRecord_Bean("告白气球"));
        historyRecord_beans.add(new HistoryRecord_Bean("浮夸"));
        historyRecord_beans.add(new HistoryRecord_Bean("华晨宇"));
        historyRecord_beans.add(new HistoryRecord_Bean("字段"));
        activity_search_recycle.setAdapter(activitySearchry_adapter);
       ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new SearchTouchHelper(historyRecord_beans,activitySearchry_adapter));
        itemTouchHelper.attachToRecyclerView(activity_search_recycle);
    }

}
