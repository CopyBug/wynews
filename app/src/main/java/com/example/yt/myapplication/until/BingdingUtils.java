package com.example.yt.myapplication.until;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.yt.myapplication.ui.activitys.MusicWebMusic;
import com.example.yt.myapplication.ui.fragments.Fragment_news;

public class BingdingUtils {
    @BindingAdapter("imageUrl")
    public static void bindImageUrl(ImageView view, String imageUrl){
        RequestOptions options =
                new RequestOptions()
                        .centerCrop()
                        .dontAnimate();

        Glide.with(view)
                .load(imageUrl)
                .apply(options)
                .into(view);
    }


    @BindingAdapter("weburl")
    public static void bindlayouturl(LinearLayout view,String weburl){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestOptions options =
                        new RequestOptions()
                                .centerCrop()
                                .dontAnimate();
                Intent intent=new Intent(Fragment_news.activity, MusicWebMusic.class);
                intent.putExtra("musicurl",weburl);

                if(Fragment_news.activity!=null){
                    Fragment_news.activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Fragment_news.activity.startActivity(intent);
                        }
                    });
                }
            }
        });

    }
}
