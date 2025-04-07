package org.project.Entities.Identity;

import java.time.LocalDateTime;
import org.project.Enums.*;
import org.project.Entities.Music.*;
import org.project.Services.Music.*;

import java.util.ArrayList;

public class artist extends account {

    private ArrayList<song> songsList;
    private ArrayList<album> albumsList;
    private ArrayList<edit_lyric_suggested> lyricSuggestedList;

    public artist() {Role = roles.ARTIST;}

    public artist(String name, String username, String password, String email, int age, roles role) {
        super(name, username, password, email, age, role);
    }

    public ArrayList<song> getSongsList() {return songsList;}

    public ArrayList<album> getAlbumsList() {return albumsList;}

    public ArrayList<edit_lyric_suggested> getLyricSuggestedList() {return lyricSuggestedList;}

    public song createNewSong(String title, String genre, String albumId, String lyric) {
        song newSong = new song();
        newSong.setTitle(title);
        newSong.setArtistId(super.getId());
        newSong.setGenre(genre);
        newSong.setAlbumId(albumId);
        newSong.setLyrics(lyric);
        newSong.setReleaseDate(LocalDateTime.now());
        this.songsList.add(newSong);
        return newSong;
    }

    public album createNewAlbum(String title, ArrayList<song> trackList) {
        album newAlbum = new album();
        newAlbum.setTitle(title);
        newAlbum.setUserId(super.getId());
        newAlbum.setTrackList(trackList);
        newAlbum.setReleaseDate(LocalDateTime.now());
        this.albumsList.add(newAlbum);
        return newAlbum;
    }
}