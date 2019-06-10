package com.example.yt.myapplication.entitys;

public class TuijianGedan_bean {
    private String imgurl;
    private String msg;
    private String bofenliang;

    public TuijianGedan_bean(String imgurl, String msg, String bofenliang) {
        this.imgurl = imgurl;
        this.msg = msg;
        this.bofenliang = bofenliang;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getBofenliang() {
        return bofenliang;
    }

    public void setBofenliang(String bofenliang) {
        this.bofenliang = bofenliang+"万";
    }
}
