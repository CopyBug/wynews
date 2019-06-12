package com.example.yt.myapplication.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yt.myapplication.R;

public class SearchViewholder extends RecyclerView.ViewHolder {


        public View rootView;
        public TextView activity_search_ry_item_tv;

        public SearchViewholder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.activity_search_ry_item_tv = (TextView) rootView.findViewById(R.id.activity_search_ry_item_tv);
        }


}
