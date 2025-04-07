package org.project.Services.Identity;

import org.project.Entities.Music.song;
import org.project.Services.*;
import org.project.Services.Identity.artistService;
import org.project.Entities.Identity.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;
import java.util.Objects;

public class adminService implements service_interface<admin>, searchService_interface<admin> {

    private final dataStorage dataStorage;
    private artistService artistService;

    public adminService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
        this.artistService = new artistService(dataStorage);
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
}