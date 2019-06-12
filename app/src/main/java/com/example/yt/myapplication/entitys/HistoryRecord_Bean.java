package com.example.yt.myapplication.entitys;

public class HistoryRecord_Bean {
    private String song_name;
    private String searchTime;

    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(String searchTime) {
        this.searchTime = searchTime;
    }

    public HistoryRecord_Bean(String song_name) {
        this.song_name = song_name;
    }

    public HistoryRecord_Bean(String song_name, String searchTime) {
        this.song_name = song_name;
        this.searchTime = searchTime;
    }
}
