package com.example.yt.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.yt.myapplication.R;
import com.example.yt.myapplication.entitys.Video_Bean;

import java.util.List;

public class VideoApater extends BaseAdapter {
    private  View view;
    List<Video_Bean> videoBeans;
    private Context context;
    LayoutInflater linearLayout;

    public VideoApater(List<Video_Bean> videoBeans, Context context) {
        this.videoBeans = videoBeans;
        this.context = context;
        linearLayout = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return videoBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return i;

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view==null){
            view=linearLayout.inflate(R.layout.fragment_video_item, viewGroup, false);
            viewHolder=new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder= (ViewHolder) view.getTag();
        }
        Glide.with(context).load(videoBeans.get(i).getImgurl()).into(viewHolder.img_item);
        viewHolder.tv_item.setText(videoBeans.get(i).getTv());

        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public VideoView video_item;
        public TextView tv_item;
        public ImageView img_item;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.video_item = (VideoView) rootView.findViewById(R.id.video_item);
            this.tv_item = (TextView) rootView.findViewById(R.id.tv_item);
            this.img_item = (ImageView) rootView.findViewById(R.id.img_item);
        }

    }
}
