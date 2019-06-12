package com.example.yt.myapplication.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yt.myapplication.R;
import com.example.yt.myapplication.ViewHolder.SearchViewholder;
import com.example.yt.myapplication.entitys.HistoryRecord_Bean;

import java.util.ArrayList;
import java.util.List;

public class ActivitySearchry_adapter extends RecyclerView.Adapter<SearchViewholder> {
List<HistoryRecord_Bean> list=new ArrayList<>();

    public ActivitySearchry_adapter(List<HistoryRecord_Bean> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public SearchViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_searc_ry_item,parent,false);
        return new SearchViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewholder holder, int position) {
        holder.activity_search_ry_item_tv.setText(list.get(position).getSong_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
