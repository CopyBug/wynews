package com.example.yt.myapplication.entitys;

public class HistoryRecord_Bean {
    private String song_name;
    private String searchTime;
    private String musicurl;

    public String getMusicurl() {
        return musicurl;
    }

    public void setMusicurl(String musicurl) {
        this.musicurl = musicurl;
    }

    @Override
    public boolean equals(Object obj) {

        return ((HistoryRecord_Bean)obj).getSong_name().equals(song_name);
    }

    @Override
    public int hashCode() {
        return song_name.hashCode();
    }

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
