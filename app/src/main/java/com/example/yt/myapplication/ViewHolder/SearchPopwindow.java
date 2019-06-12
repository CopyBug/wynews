package com.example.yt.myapplication.ViewHolder;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yt.myapplication.R;

public class SearchPopwindow {
        public View rootView;
        public TextView usertv;
        public ListView activity_search_poplv;
        public SearchPopwindow(View rootView) {
            this.rootView = rootView;
            this.usertv = (TextView) rootView.findViewById(R.id.usertv);
            this.activity_search_poplv = (ListView) rootView.findViewById(R.id.activity_search_poplv);
        }


}
