package org.project.Entities.Music;

import org.project.Entities.entity;
import java.time.LocalDateTime;

public class song extends entity {

    private String AlbumId;
    private String Title;
    private String Lyric;
    private String Genre;
    private LocalDateTime ReleaseDate;
    private int ViewsCount;

    public song() {}

    public song(String albumId, String title, String lyric, String genre, LocalDateTime releaseDate, int viewsCount) {
        this.AlbumId = albumId;
        this.Title = title;
        this.Lyric = lyric;
        this.Genre = genre;
        this.ReleaseDate = releaseDate;
        this.ViewsCount = viewsCount;
    }

    public String getAlbumId() {return AlbumId;}

    public void setAlbumId(String albumId) {this.AlbumId = albumId;}

    public String getTitle() {return Title;}

    public void setTitle(String title) {this.Title = title;}

    public String getLyrics() {return Lyric;}

    public void setLyrics(String lyrics) {this.Lyric = lyrics;}

    public LocalDateTime getReleaseDate() {return ReleaseDate;}

    public void setReleaseDate(LocalDateTime releaseDate) {this.ReleaseDate = releaseDate;}

    public int getViewsCount() {return ViewsCount;}

    public void incrementViewsCount() {this.ViewsCount++;}

    public String getGenre() {return Genre;}

    public void setGenre(String genre) {this.Genre = genre;}
}