package com.example.yt.myapplication.until;

import android.app.Activity;
import android.view.WindowManager;

import java.util.Collections;
import java.util.Map;

public class OfenUntil {
    public static void CancelActionBar(Activity activity){
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

}
