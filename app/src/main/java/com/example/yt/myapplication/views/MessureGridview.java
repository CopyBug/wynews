package com.example.yt.myapplication.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class MessureGridview  extends GridView {
    public MessureGridview(Context context) {
        super(context);
    }

    public MessureGridview(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MessureGridview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec=MeasureSpec.makeMeasureSpec(999999,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
