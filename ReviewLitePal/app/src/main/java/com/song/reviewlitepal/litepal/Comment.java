package com.song.reviewlitepal.litepal;

import org.litepal.crud.LitePalSupport;

public class Comment extends LitePalSupport {
    private int id;
    private String content;
    private Songs songs;

    public Songs getSongs() {
        return songs;
    }

    public void setSongs(Songs songs) {
        this.songs = songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
