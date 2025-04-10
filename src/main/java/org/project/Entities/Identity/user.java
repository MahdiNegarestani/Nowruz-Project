package org.project.Entities.Identity;

import org.project.Enums.*;
import org.project.Entities.Music.*;
import java.time.LocalDateTime;

public class user extends account {

    private final artistsFollowing artistsFollowing = new artistsFollowing();

    public user() {
        super();
        Role = roles.USER;
        this.artistsFollowing.setUserId(getId());
    }

    public artistsFollowing getArtistsFollowing() {return this.artistsFollowing;}

    public user(String name, String username, String password, String email, int age, roles role) {
        super(name, username, password, email, age, role);
    }

    public edit_lyric_suggested suggestEdit(song song, String suggestedLyric) {
        edit_lyric_suggested suggested = new edit_lyric_suggested();
        suggested.setSongId(song.getId());
        suggested.setUserId(getId());
        suggested.setLyrics(suggestedLyric);
        return suggested;
    }

    public comment leaveComment(song song, String comment) {
        comment comment1 = new comment();
        comment1.setContent(comment);
        comment1.setUserId(getId());
        comment1.setSongId(song.getId());
        comment1.setReleaseDate(LocalDateTime.now());
        return comment1;
    }

    public void followArtist(String artistId) {artistsFollowing.addArtistId(artistId);}
}