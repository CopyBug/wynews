package com.example.yt.myapplication.TouchHelper;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.example.yt.myapplication.adapters.ActivitySearchry_adapter;
import com.example.yt.myapplication.entitys.HistoryRecord_Bean;

import java.util.Collections;
import java.util.List;

public class SearchTouchHelper extends ItemTouchHelper.Callback {
    List<HistoryRecord_Bean> historyRecord_beans;
    ActivitySearchry_adapter activitySearchry_adapter;

    public SearchTouchHelper(List<HistoryRecord_Bean> historyRecord_beans, ActivitySearchry_adapter activitySearchry_adapter) {
        this.historyRecord_beans = historyRecord_beans;
        this.activitySearchry_adapter = activitySearchry_adapter;
    }


    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        final  int dragFlags=ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        return makeMovementFlags(dragFlags,1);

    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();//得到拖动ViewHolder的position
        int toPosition = target.getAdapterPosition();//得到目标ViewHolder的position
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(historyRecord_beans, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(historyRecord_beans, i, i - 1);
            }
        }
        activitySearchry_adapter.notifyItemMoved(fromPosition, toPosition);

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
}
