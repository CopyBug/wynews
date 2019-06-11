package com.example.yt.myapplication.entitys;

public class Myself_Bean {
    public int getIcon_img() {
        return icon_img;
    }


    public void setIcon_img(int icon_img) {
        this.icon_img = icon_img;
    }

    public String getIcon_tv() {
        return icon_tv;
    }

    public void setIcon_tv(String icon_tv) {
        this.icon_tv = icon_tv;
    }

    public String getIcon_num() {
        return icon_num;
    }

    public void setIcon_num(String icon_num) {
        this.icon_num = "("+icon_num+")";
    }

    private int icon_img;
private String icon_tv;
private String icon_num;
}
