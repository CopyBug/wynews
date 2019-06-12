package com.example.yt.myapplication.ui.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.TouchHelper.SearchTouchHelper;
import com.example.yt.myapplication.ViewHolder.SearchPopwindow;
import com.example.yt.myapplication.adapters.ActivitySearchPopItemAdapter;
import com.example.yt.myapplication.adapters.ActivitySearchry_adapter;
import com.example.yt.myapplication.entitys.HistoryRecord_Bean;
import com.example.yt.myapplication.entitys.MusicSong_bean;
import com.example.yt.myapplication.until.NetworkListining;
import com.example.yt.myapplication.until.OfenUntil;
import com.example.yt.myapplication.until.OkhttpUntil;
import com.example.yt.myapplication.views.MessureListview;
import com.example.yt.myapplication.views.MessureRecyclerView;
import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.SimpleFormatter;

public class SearchActivity extends AppCompatActivity {

    private ImageView activity_search_up;
    private EditText activity_search_son;
    private ImageView activity_search_delete;
    private MessureRecyclerView activity_search_recycle;
    private MessureListview activity_search_lv;
    private ActivitySearchry_adapter activitySearchry_adapter;
    private List<HistoryRecord_Bean> historyRecord_beans=new ArrayList<>();
    private List<MusicSong_bean.ListbeanBean> listbeanBeans;
    private ActivitySearchPopItemAdapter popItemAdapter;
    private PopupWindow popupWindow;
    private ListView activity_search_poplv;
    List<MusicSong_bean.ListbeanBean> listbean ;
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
                String sonhead = activity_search_son.getText() + "".trim();
                if(!sonhead.equals("")){
                    popupWindow = OfenUntil.searchRelated(SearchActivity.this, initpop(sonhead), "#FFFFFF", activity_search_son);
                    GetSons(sonhead);

                }else{
                    if(popupWindow!=null){
                        OfenUntil.Dispop(popupWindow);
                    }
                }

            }
        });
    }
    /*搜索监听器*/
    private void addHistory() {
        activity_search_poplv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(popupWindow!=null&&listbean!=null){
                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd");
                    String format = simpleDateFormat.format(new Date());
                    OfenUntil.Dispop(popupWindow);
                    History history = OfenUntil.SelectSharep(SearchActivity.this, "lhw", "history", History.class);
                    if(history==null){
                        Set<HistoryRecord_Bean>  historyRecord_beans=new HashSet<>();
                        historyRecord_beans.add(new HistoryRecord_Bean(listbean.get(position).getSonname(),format));
                        history=new History(historyRecord_beans);
                    }else{
                        Set<HistoryRecord_Bean> historyRecord_beans = history.getHistoryRecord_beans();
                        historyRecord_beans.add(new HistoryRecord_Bean(listbean.get(position).getSonname(),format));
                    }
                    OfenUntil.StorageSharep(SearchActivity.this,"lhw","history",new Gson().toJson(history));
                    AddHistory();
                }
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
    /*初始化历史记录适配器*/
    public void initHistory(){
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        activity_search_recycle.setLayoutManager(layoutManager);
        activitySearchry_adapter=new ActivitySearchry_adapter(historyRecord_beans);
        activity_search_recycle.setAdapter(activitySearchry_adapter);
       ItemTouchHelper itemTouchHelper=new ItemTouchHelper(new SearchTouchHelper(historyRecord_beans,activitySearchry_adapter));
        itemTouchHelper.attachToRecyclerView(activity_search_recycle);
        AddHistory();
    }
    /*更新历史记录*/
    public void AddHistory(){
        historyRecord_beans.clear();
        History history = OfenUntil.SelectSharep(SearchActivity.this, "lhw", "history", History.class);
        if(history!=null){
           List<HistoryRecord_Bean> beans=new ArrayList<>( history.getHistoryRecord_beans());
            for (int i = 0; i < beans.size(); i++) {
                historyRecord_beans.add(beans.get(i));
            }
            activitySearchry_adapter.notifyDataSetChanged();
        }else{
            activitySearchry_adapter.notifyDataSetChanged();
        }

    }
    /*获取歌*/
    public void GetSons(String head){
        OkhttpUntil.enqueueGetrequest("http://192.168.1.205:12301/StudentP/SELECTHeadmusic?musichead=" + head, MusicSong_bean.class, new NetworkListining<MusicSong_bean>() {
            @Override
            public void BackResultSuccess(MusicSong_bean bean, int code) {
                try{
                    if(bean!=null){
                        if (bean.isResult()){
                            listbean=bean.getListbean();
                            for (int i = 0; i < listbean.size(); i++) {
                                listbeanBeans.add(listbean.get(i));
                            }
                            popItemAdapter.notifyDataSetChanged();

                        }
                    }
                }catch (Exception e){

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
    /*初始化pop*/
    public View initpop(String ziduan){
        listbeanBeans=new ArrayList<>();
        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_search_pop, null, false);
        SearchPopwindow searchPopwindow=new SearchPopwindow(inflate);
        searchPopwindow.usertv.setText(ziduan);
        activity_search_poplv = searchPopwindow.activity_search_poplv;
        popItemAdapter = new ActivitySearchPopItemAdapter(listbeanBeans, this);
        activity_search_poplv.setAdapter(popItemAdapter);
        addHistory();
        return inflate;
    }
    /*删除历史记录*/
    public void DelethistoryRecord(View view){
        OfenUntil.StorageSharep(this,"lhw","history",null);
        AddHistory();
    }
    public class History{
        Set<HistoryRecord_Bean> historyRecord_beans=new HashSet<>();

        public History(Set<HistoryRecord_Bean> historyRecord_beans) {
            this.historyRecord_beans = historyRecord_beans;
        }

        public Set<HistoryRecord_Bean> getHistoryRecord_beans() {
            return historyRecord_beans;
        }

        public void setHistoryRecord_beans(Set<HistoryRecord_Bean> historyRecord_beans) {
            this.historyRecord_beans = historyRecord_beans;
        }
    }
}
