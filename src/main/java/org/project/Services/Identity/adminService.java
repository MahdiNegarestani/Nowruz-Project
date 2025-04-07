package org.project.Services.Identity;

import org.project.Entities.Music.edit_lyric_suggested;
import org.project.Entities.Music.song;
import org.project.Enums.edit_lyric_status;
import org.project.Services.*;
import org.project.Services.Music.songService;
import org.project.Services.Identity.artistService;
import org.project.Entities.Identity.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;
import java.util.Objects;

public class adminService implements service_interface<admin>, searchService_interface<admin> {

    private final dataStorage dataStorage;
    private artistService artistService;
    private songService songService;

    public adminService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
        this.artistService = new artistService(dataStorage);
        this.songService = new songService(dataStorage);
    }

    public admin getById(String id) {
        for (account account: dataStorage.Accounts){
            if (account instanceof admin){
                if (Objects.equals(id, account.getId())){
                    return (admin) account;
                }
            }
        }
        return null;
    }

    public void add(admin u) {
        dataStorage.Accounts.add(u);
    }

    public void edit(admin u) {
        dataStorage.Accounts.set(dataStorage.Accounts.indexOf(u), u);
    }

    public void delete(admin u) {
        dataStorage.Accounts.remove(dataStorage.Accounts.indexOf(u));
    }

    public ArrayList<admin> getAll() {
        ArrayList<admin> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof admin){
                all.add((admin) account);
            }
        }
        return all;
    }

    public ArrayList<admin> getBySearch(String search) {
        ArrayList<admin> all = new ArrayList<>();
        for (account account: dataStorage.Accounts){
            if (account instanceof admin){
                if (Objects.equals(search, account.getName())){
                    all.add((admin)account);
                }
            }
        }
        return all;
    }

    public void viewTheSong(song song) {
        System.out.println("Title: " + song.getTitle() + "\nGenre: " + song.getGenre() + "\nArtist_Name: " + artistService.getById(song.getArtistId()).getName() + "\nLyric: " + song.getLyrics());
        song.incrementViewsCount();
    }

    public void approvalAccount(account account) {
        if (dataStorage.AccountsRegisterd.contains(account)){
            dataStorage.Accounts.add(account);
            dataStorage.AccountsRegisterd.remove(account);
        }
        else {System.out.println("Account not registered");}
    }

    public void viewAccountsRegisterdList() {
        int i = 1;
        for (account account: dataStorage.AccountsRegisterd){
            System.out.println(i + " : " + account.getName());
            i ++;
        }
    }

    public void approvingSuggestedLyric(edit_lyric_suggested suggested, artist current_) {
        if (Objects.equals(songService.getById(suggested.getSongId()).getArtistId(), current_.getId())){
            suggested.setEditLyricsSuggestStatus(edit_lyric_status.APPROVED);
            songService.getById(suggested.getSongId()).setLyrics(suggested.getLyrics());
        } else {
            System.out.println("Song does not exist in your songsList");
        }
    }

    public void rejectingSuggestedLyric(edit_lyric_suggested suggested, artist current_) {
        if (Objects.equals(songService.getById(suggested.getSongId()).getArtistId(), current_.getId())){
            suggested.setEditLyricsSuggestStatus(edit_lyric_status.REJECTED);
        } else {
            System.out.println("Song does not exist in your songsList");
        }
    }

}