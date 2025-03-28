package org.project.Entities.Music;

import org.project.Entities.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class comment extends entity {
    private String userId;
    private String songId;
    private String content;
    private LocalDateTime releaseDate;

    public comment() {}

    public comment(String userId, String songId, String content, LocalDateTime releaseDate) {
        super();
        this.userId = userId;
        this.songId = songId;
        this.content = content;
        this.releaseDate = releaseDate;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getReleaseDate() {return this.releaseDate;}
}