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

import com.bumptech.glide.Glide;
import com.example.yt.myapplication.R;
import com.example.yt.myapplication.entitys.Myself_Bean;

public class FragmentMyselfLvItemAdapter extends BaseAdapter {

    private List<Myself_Bean> objects = new ArrayList<Myself_Bean>();

    private Context context;
    private LayoutInflater layoutInflater;


    public FragmentMyselfLvItemAdapter(List<Myself_Bean> objects, Context context) {
        this.objects = objects;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Myself_Bean getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.fragment_myself_lv_item, null);
            convertView.setTag(new ViewHolder(convertView));
        }
        initializeViews((Myself_Bean)getItem(position), (ViewHolder) convertView.getTag());
        return convertView;
    }

    private void initializeViews(Myself_Bean object, ViewHolder holder) {
        //TODO implement
        Glide.with(context).load(object.getIcon_img()).into(holder.iconImag);
        holder.iconTv.setText(object.getIcon_tv());
        holder.iconNum.setText(object.getIcon_num());
    }

    protected class ViewHolder {
        private ImageView iconImag;
    private TextView iconTv;
    private TextView iconNum;

        public ViewHolder(View view) {
            iconImag = (ImageView) view.findViewById(R.id.icon_imag);
            iconTv = (TextView) view.findViewById(R.id.icon_tv);
            iconNum = (TextView) view.findViewById(R.id.icon_num);
        }
    }
}
