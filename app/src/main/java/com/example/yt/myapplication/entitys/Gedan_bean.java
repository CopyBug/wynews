package com.example.yt.myapplication.entitys;

public class Gedan_bean {
    private int img;
    private String title;
    private String songList;

    public int getImg() {
        return img;
    }

    public Gedan_bean(int img, String title, String songList) {
        this.img = img;
        this.title = title;
        this.songList = songList;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSongList() {
        return songList;
    }

    public void setSongList(String songList) {
        this.songList = songList;
    }

    public Gedan_bean(String songList) {
        this.songList = songList;
    }
}
