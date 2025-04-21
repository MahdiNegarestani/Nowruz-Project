package org.project.Services.Music;

import org.project.Main;
import org.project.Services.*;
import org.project.Entities.Music.*;
import org.project.DataStorage.dataStorage;

import java.util.ArrayList;
import java.util.Objects;
import java.util.AbstractMap;

public class songService implements service_interface<song>, searchService_interface<song> {

    dataStorage dataStorage;

    public songService(dataStorage dataStorage) {this.dataStorage = dataStorage;}

    public song getById(String id) {
        for (song song: dataStorage.Songs){
           if (song.getId().equals(id)){
               return song;
           }
        }
        return null;
    }

    public void add(song u) {
        dataStorage.Songs.add(u);
    }

    public void edit(song u) {
        dataStorage.Songs.set(dataStorage.Songs.indexOf(u), u);
    }

    public void delete(song u) {
        dataStorage.Songs.remove(u);
    }

    public ArrayList<song> getAll() {
        return new ArrayList<>(dataStorage.Songs);
    }

    public ArrayList<song> getBySearch(String search) {
        ArrayList<song> all = new ArrayList<>();
        for (song song: dataStorage.Songs){
            if (Objects.equals(search, song.getTitle())){
                all.add(song);
            }
        }
        return all;
    }

    public ArrayList<AbstractMap.SimpleEntry<song, Integer>> charts() {
        if (getAll() == null){return null;}
        else {
            ArrayList<AbstractMap.SimpleEntry<song, Integer>> pairs = new ArrayList<>();
            for (song song: dataStorage.Songs){
                pairs.add(new AbstractMap.SimpleEntry<>(song, song.getViewsCount()));
            }
            int i = 1;
            for (AbstractMap.SimpleEntry<song, Integer> pair: pairs){
                System.out.println(i + ". " + pair.getKey().getTitle() + " with " + pair.getValue() + " views");
                i ++;
            }
            return pairs;
        }
    }

    public void viewTheSong(song song) {
        System.out.println("Title: " + song.getTitle() + "\nGenre: " + song.getGenre() + "\nArtist_Name: " + Main.getServices.getArtistService().getById(song.getArtistId()).getName() + "\nLyric: " + song.getLyrics());
        song.incrementViewsCount();
    }
}