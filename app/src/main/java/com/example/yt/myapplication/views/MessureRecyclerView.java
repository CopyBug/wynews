package com.example.yt.myapplication.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

public class MessureRecyclerView extends RecyclerView {
    public MessureRecyclerView(Context context) {
        super(context);
    }

    public MessureRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MessureRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        heightSpec=MeasureSpec.makeMeasureSpec(999999,MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, heightSpec);
    }
}
