package org.project.Entities.Music;

import org.project.Entities.entity;
import org.project.Enums.edit_lyric_status;

public class edit_lyric_suggested extends entity {

    private String lyric;
    private edit_lyric_status status;
    private String userId;
    private String songId;

    public edit_lyric_suggested() {this.status = edit_lyric_status.PENDING;}

    public edit_lyric_suggested(String lyric, edit_lyric_status status, String userId, String songId) {
        super();
        this.lyric = lyric;
        this.status = status;
        this.userId = userId;
        this.songId = songId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getLyrics() {
        return lyric;
    }

    public void setLyrics(String lyrics) {
        this.lyric = lyrics;
    }

    public edit_lyric_status getEditLyricsSuggestStatus() {
        return status;
    }

    public void setEditLyricsSuggestStatus(edit_lyric_status editLyricsSuggestStatus) {
        this.status = editLyricsSuggestStatus;
    }
}