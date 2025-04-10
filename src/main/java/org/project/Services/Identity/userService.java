package org.project.Services.Identity;

import org.project.Entities.Music.song;
import org.project.Services.*;
import org.project.Entities.Identity.*;
import org.project.Entities.Music.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;
import java.util.Objects;

public class userService implements service_interface<user>, searchService_interface<user> {

    private final dataStorage dataStorage;
    private final artistService artistService;

    public userService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
        this.artistService = new artistService(dataStorage);
    }

    public user getById(String id) {
        for (account account: dataStorage.Accounts){
            if (account instanceof user){
                if (Objects.equals(id, account.getId())){
                    return (user)account;
                }
            }
        }
        return null;
    }

    public void add(user u) {
        dataStorage.Accounts.add(u);
    }

    public void edit(user u) {
        dataStorage.Accounts.set(dataStorage.Accounts.indexOf(u), u);
    }

    public void delete(user u) {
        dataStorage.Accounts.remove(dataStorage.Accounts.indexOf(u));
    }

    public ArrayList<user> getAll() {
        ArrayList<user> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof user){
                all.add((user)account);
            }
        }
        return all;
    }

    public ArrayList<user> getBySearch(String search) {
        ArrayList<user> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof user){
                if (Objects.equals(search, account.getName())){
                    all.add((user)account);
                }
            }
        }
        return all;
    }

    public void createEditLyrics(song song, String suggestedLyric, user current_){
        edit_lyric_suggested result = current_.suggestEdit(song, suggestedLyric);
        this.dataStorage.EditLyricsSuggests.add(result);
    }

    public song searchSong(String search) {
        song songResult = new song();
        boolean check = false;
        for (song song: dataStorage.Songs){
            if (Objects.equals(search, song.getTitle())){
                songResult = song;
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Song not found");
            return null;
        }
        return songResult;
    }

    public artist searchArtist(String search) {
        artist artistResult = new artist();
        boolean check = false;
        for (account account: dataStorage.Accounts){
            if (account instanceof artist){
                if (Objects.equals(search, account.getName())){
                    artistResult = (artist)account;
                    check = true;
                    break;
                }
            }
        }
        if (!check){
            System.out.println("Artist not found");
            return null;
        }
        return artistResult;
    }

    public album searchAlbum(String search) {
        album albumResult = new album();
        boolean check = false;
        for (album album: dataStorage.Albums){
            if (Objects.equals(search, album.getTitle())){
                albumResult = album;
                check = true;
                break;
            }
        }
        if (!check){
            System.out.println("Album not found");
            return null;
        }
        return albumResult;
    }

    public void creatComments(song song, String comment, user current_) {
        comment commentResult = current_.leaveComment(song, comment);
        this.dataStorage.Comments.add(commentResult);
    }

    public void viewTheSong(song song) {
        System.out.println("Title: " + song.getTitle() + "\nGenre: " + song.getGenre() + "\nArtist_Name: " + artistService.getById(song.getArtistId()).getName() + "\nLyric: " + song.getLyrics());
        song.incrementViewsCount();
    }

    public ArrayList<artist> showFollowingArtistsNames(user current_) {
        ArrayList<String> artistsId = current_.getArtistsFollowing().getArtistsId();
        ArrayList<artist> temp = new ArrayList<>();
        for (String artistId: artistsId){
            temp.add(artistService.getById(artistId));
        }
        int i = 1;
        for (artist artist: temp){
            System.out.println(i + " . " + artist.getName());
            i ++;
        }
        return temp;
    }
}