package org.project.Services.Identity;

import org.project.Enums.edit_lyric_status;
import org.project.Main;
import org.project.Services.*;
import org.project.Entities.Identity.*;
import org.project.Entities.Music.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;
import java.util.Objects;

public class artistService implements service_interface<artist>, searchService_interface<artist> {

    private final dataStorage dataStorage;

    public artistService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public artist getById(String id) {
        for (account account: dataStorage.Accounts){
            if (account instanceof artist){
                if (Objects.equals(id, account.getId())){
                    return (artist) account;
                }
            }
        }
        return null;
    }

    public void add(artist u) {
        dataStorage.Accounts.add(u);
    }

    public void edit(artist u) {
        dataStorage.Accounts.set(dataStorage.Accounts.indexOf(u), u);
    }

    public void delete(artist u) {
        dataStorage.Accounts.remove(dataStorage.Accounts.indexOf(u));
    }

    public ArrayList<artist> getAll() {
        ArrayList<artist> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof artist){
                all.add((artist) account);
            }
        }
        return all;
    }

    public ArrayList<artist> getBySearch(String search) {
        ArrayList<artist> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof artist){
                if (Objects.equals(search, account.getName())){
                    all.add((artist)account);
                }
            }
        }
        return all;
    }

    public void editSong(song song, String editLyric, artist current_) {
        if (Objects.equals(song.getArtistId(), current_.getId())){
            song.setLyrics(editLyric);
        } else {
            System.out.println("Song does not exist in your songsList");
        }
    }

    public void showListOfSongs(artist current_) {
        int i = 1;
        for (song song: current_.getSongsList()){
            System.out.println(i + ". " + song.getTitle());
            i ++;
        }
    }

    public void showListOfAlbums(artist current_) {
        int i = 1;
        for (album album: current_.getAlbumsList()){
            System.out.println(i + ". " + album.getTitle());
            i ++;
        }
    }

    public void addingSuggestedLyric(edit_lyric_suggested lyricSuggested, artist current_) {
        current_.getLyricSuggestedList().add(lyricSuggested);
    }

    public void showListOfLyrics(artist current_) {
        int i = 1;
        for (edit_lyric_suggested suggested: current_.getLyricSuggestedList()){
            System.out.println(i + ". " + Main.getServices.getSongService().getById(suggested.getSongId()).getTitle());
        }
    }

    public void approvingSuggestedLyric(edit_lyric_suggested suggested, artist current_) {
        if (Objects.equals(Main.getServices.getSongService().getById(suggested.getSongId()).getArtistId(), current_.getId())){
            suggested.setEditLyricsSuggestStatus(edit_lyric_status.APPROVED);
            Main.getServices.getSongService().getById(suggested.getSongId()).setLyrics(suggested.getLyrics());
        } else {
            System.out.println("Song does not exist in your songsList");
        }
    }

    public void rejectingSuggestedLyric(edit_lyric_suggested suggested, artist current_) {
        if (Objects.equals(Main.getServices.getSongService().getById(suggested.getSongId()).getArtistId(), current_.getId())){
            suggested.setEditLyricsSuggestStatus(edit_lyric_status.REJECTED);
        } else {
            System.out.println("Song does not exist in your songsList");
        }
    }

    public void createNewSong(String title, String genre, String albumId, String lyric, artist current_) {
        song newSong = current_.createNewSong(title, genre, albumId, lyric);
        this.dataStorage.Songs.add(newSong);
    }

    public void createNewAlbum(String title, ArrayList<song> trackList, artist current_) {
        album newAlbum = current_.createNewAlbum(title, trackList);
        this.dataStorage.Albums.add(newAlbum);
    }

    public void addSongToAlbum(song song, artist current_) {
        current_.getSongsList().add(song);

    }

    public void viewTheSong(song song) {
        System.out.println("Title: " + song.getTitle() + "\nGenre: " + song.getGenre() + "\nArtist_Name: " + this.getById(song.getArtistId()).getName() + "\nLyric: " + song.getLyrics());
        song.incrementViewsCount();
    }
}