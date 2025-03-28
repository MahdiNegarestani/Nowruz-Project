package org.project.Entities.Music;

import org.project.Entities.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class album extends entity {

    private String userId;
    private String title;
    private LocalDateTime releaseDate;
    private ArrayList<song> trackList;

    public album() {}

    public album(String userId, String title, LocalDateTime releaseDate, ArrayList<song> trackList) {
        super();
        this.userId = userId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trackList = trackList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ArrayList<song> getTrackList() {
        return trackList;
    }

    public void setTrackList(ArrayList<song> trackList) {
        this.trackList = trackList;
    }
}
