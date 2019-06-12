package com.example.yt.myapplication.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.entitys.MusicSong_bean;

public class ActivitySearchPopItemAdapter extends BaseAdapter {

    private List<MusicSong_bean.ListbeanBean> objects = new ArrayList<MusicSong_bean.ListbeanBean>();

    private Context context;
    private LayoutInflater layoutInflater;


    public ActivitySearchPopItemAdapter(List<MusicSong_bean.ListbeanBean> objects, Context context) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public MusicSong_bean.ListbeanBean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.activity_search_pop_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((MusicSong_bean.ListbeanBean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(MusicSong_bean.ListbeanBean object, ViewHolder holder) {
        holder.activitySearchPopTv.setText(object.getSonname()+"");

    }

    protected class ViewHolder {
        private ImageView activitySearchPopImg;
    private TextView activitySearchPopTv;

        public ViewHolder(View view) {
            activitySearchPopImg = (ImageView) view.findViewById(R.id.activity_search_pop_img);
            activitySearchPopTv = (TextView) view.findViewById(R.id.activity_search_pop_tv);
        }
    }
}
