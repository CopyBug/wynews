package com.example.yt.myapplication.until;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.yt.myapplication.R;

import java.util.Collections;
import java.util.Map;

public class OfenUntil {
    public static void CancelActionBar(Activity activity){
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
    public static void JumpActivity(Activity activity,Class activityclass){
        Intent intent = new Intent(activity, activityclass);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.enteranim,R.anim.exitanim);
    }
    public static void JumpActivity(Activity activity,Class activityclass,String key,String value){
        Intent intent = new Intent(activity, activityclass);
        intent.putExtra(key,value);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.enteranim,R.anim.exitanim);
    }
    public static void ChangestatusBar(Activity activity,String colors){
        Window window = activity.getWindow();
        window.setStatusBarColor(Color.parseColor(colors));
    }
    /*pop*/
    public void searchRelated(Activity activity,String usertv, View view, String  bgcolor, View location){
        PopupWindow popupWindow = new PopupWindow(activity);
        popupWindow.setContentView(view);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(false);
        ColorDrawable cd = new ColorDrawable(Color.parseColor("bgcolor"));
        popupWindow.setBackgroundDrawable(cd);
        popupWindow.showAsDropDown(location);

    }
}
