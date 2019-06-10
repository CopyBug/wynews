package com.example.yt.myapplication.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yt.myapplication.R;
import com.example.yt.myapplication.entitys.TuijianGedan_bean;

public class HostGvAdapter extends BaseAdapter {

    private List<TuijianGedan_bean> objects = new ArrayList<TuijianGedan_bean>();

    private Context context;
    private LayoutInflater layoutInflater;



    public HostGvAdapter(List<TuijianGedan_bean> objects, Context context) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public TuijianGedan_bean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.host_gv, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((TuijianGedan_bean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(TuijianGedan_bean object, ViewHolder holder) {
        //TODO implement
    Glide.with(context).load(object.getImgurl()).into(holder.gvImg);

        holder.sonTv.setText(object.getMsg());
        holder.gvBofanlian.setText(object.getBofenliang());
    }

    protected class ViewHolder {
        private ImageView gvImg;
    private TextView sonTv;
    private TextView gvBofanlian;

        public ViewHolder(View view) {
            gvImg = (ImageView) view.findViewById(R.id.gv_img);
            sonTv = (TextView) view.findViewById(R.id.son_tv);
            gvBofanlian = (TextView) view.findViewById(R.id.gv_bofanlian);
        }
    }
}
