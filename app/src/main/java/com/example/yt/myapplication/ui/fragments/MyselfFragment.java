package com.example.yt.myapplication.ui.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.adapters.FragmentMyselfLvItemAdapter;
import com.example.yt.myapplication.entitys.Gedan_bean;
import com.example.yt.myapplication.entitys.Myself_Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MyselfFragment extends BaseFragment {
    private ListView myself_lv;
    private ExpandableListView myself_Elv;
    private FragmentMyselfLvItemAdapter fragmentMyselfLvItemAdapter;
    private List<Myself_Bean> myself_beans = new ArrayList<>();
    private Map<String, List<Gedan_bean>> maps = new LinkedHashMap<>();
    private EpAdapter epAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = getActivity();
        View view = FindView(inflater, container, R.layout.fragment_meself);
        initView(view);
        return view;
    }

    private void initView(View view) {
        myself_lv = view.findViewById(R.id.myself_lv);
        myself_Elv = (ExpandableListView) view.findViewById(R.id.myself_Elv);

        initlv();
        initep();
    }

    public void initlv() {

        fragmentMyselfLvItemAdapter = new FragmentMyselfLvItemAdapter(myself_beans, activity);
        myself_lv.setAdapter(fragmentMyselfLvItemAdapter);

        additemMyself_Bean(R.mipmap.icon_phone, "本地音乐", 0);
        additemMyself_Bean(R.mipmap.icon_lishi, "最近播放", 0);
        additemMyself_Bean(R.mipmap.icon_down, "下载管理", 0);
        additemMyself_Bean(R.mipmap.icon_geshou, "我的歌手", 0);
    }
    public  void initep(){
        myself_Elv.setGroupIndicator(null);
        ArrayList<Gedan_bean> gedan_beans = new ArrayList<>();
        gedan_beans.add(new Gedan_bean(R.mipmap.icon_love,"我喜欢的音乐","0"));
        //map.put("创建的歌单",new ArrayList<Gedan_bean>());
        maps.put("创建的歌单",gedan_beans);
        maps.put("收藏的歌单",gedan_beans);
        epAdapter=new EpAdapter(maps);
        myself_Elv.setAdapter(epAdapter);
        myself_Elv.expandGroup(0);
        myself_Elv.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                for (int i = 0; i <maps.size() ; i++) {
                    if (groupPosition != i) {
                        myself_Elv.collapseGroup(i);
                    }
                }
            }
        });
    }


    public void additemMyself_Bean(int iconimg, String icon_tv, int icon_num) {
        Myself_Bean myself_bean = new Myself_Bean();
        myself_bean.setIcon_img(iconimg);
        myself_bean.setIcon_tv(icon_tv);
        myself_bean.setIcon_num(icon_num + "");
        myself_beans.add(myself_bean);
        fragmentMyselfLvItemAdapter.notifyDataSetChanged();
    }

    public class EpAdapter extends BaseExpandableListAdapter {
        private Map<String, List<Gedan_bean>> map = new LinkedHashMap<>();
        private List<String> key ;
        public EpAdapter(Map<String, List<Gedan_bean>> map) {
            this.map = map;
            key= new ArrayList<>(map.keySet());
        }

        @Override
        public int getGroupCount() {
            return map.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return map.get(key.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupPosition;
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {


                    ViewHolder viewHolder;
                    if (convertView == null) {
                        convertView = LayoutInflater.from(activity).inflate(R.layout.fragment_myself_group, null);
                        viewHolder = new ViewHolder(convertView);
                        convertView.setTag(viewHolder);
                    } else {
                        viewHolder = (ViewHolder) convertView.getTag();
                    }
                    viewHolder.item1.setText(key.get(groupPosition));
                    viewHolder.item2.setText("(" + map.get(key.get(groupPosition)).size() + ")");
                    if (isExpanded) {
                        viewHolder.img.setRotation(90);
                    } else {
                        viewHolder.img.setRotation(0);
                    }

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            List<Gedan_bean> gedan_beans = map.get(key.get(groupPosition));
            Gedan_bean gedan_bean = gedan_beans.get(childPosition);
            ViewHolderitem viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(activity).inflate(R.layout.fragment_myself_group_item, parent,false);
                viewHolder = new ViewHolderitem(convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolderitem) convertView.getTag();
            }
            viewHolder.fragment_myself_icon.setImageResource(gedan_bean.getImg());
            viewHolder.fragment_main_playlist_item_title.setText(gedan_bean.getTitle());
            viewHolder.fragment_main_playlist_item_count.setText(gedan_bean.getSongList());
            Animation animation = AnimationUtils.loadAnimation(activity, R.anim.expandanimation);
            convertView.setAnimation(animation);
            return  convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }



    }
    public class ViewHolder {
        public View rootView;
        public ImageView img;
        public TextView item1;
        public TextView item2;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.img=rootView.findViewById(R.id.img);
            this.item1 = (TextView) rootView.findViewById(R.id.item1);
            this.item2 = (TextView) rootView.findViewById(R.id.item2);
        }

    }

    class ViewHolderitem {
        public View rootView;
        public FrameLayout fragment_main_playlist_item_lay;
        public TextView fragment_main_playlist_item_title;
        public TextView fragment_main_playlist_item_count;
        public ImageView fragment_main_playlist_item_menu;
        public ImageView fragment_myself_icon;

        public ViewHolderitem(View rootView) {
            this.rootView = rootView;

            this.fragment_main_playlist_item_lay = (FrameLayout) rootView.findViewById(R.id.fragment_main_playlist_item_lay);
            this.fragment_main_playlist_item_title = (TextView) rootView.findViewById(R.id.fragment_main_playlist_item_title);
            this.fragment_main_playlist_item_count = (TextView) rootView.findViewById(R.id.fragment_main_playlist_item_count);
            this.fragment_main_playlist_item_menu = (ImageView) rootView.findViewById(R.id.fragment_main_playlist_item_menu);
            this.fragment_myself_icon = (ImageView) rootView.findViewById(R.id.fragment_myself_icon);
        }

    }
}
