package org.project.Services.Music;

import org.project.Services.*;
import org.project.Entities.Music.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;
import java.util.Objects;

public class albumService implements service_interface<album>, searchService_interface<album> {

    dataStorage dataStorage;

    public albumService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public album getById(String id) {
        for (album album: dataStorage.Albums){
            if (album.getId().equals(id)){
                return album;
            }
        }
        return null;
    }

    public void add(album u) {
        dataStorage.Albums.add(u);
    }

    public void edit(album u) {
        dataStorage.Albums.set(dataStorage.Albums.indexOf(u), u);
    }

    public void delete(album u) {
        dataStorage.Albums.remove(u);
    }

    public ArrayList<album> getAll() {
        return new ArrayList<>(dataStorage.Albums);
    }

    public ArrayList<album> getBySearch(String search) {
        ArrayList<album> all = new ArrayList<>();
        for (album album: dataStorage.Albums){
            if (Objects.equals(search, album.getTitle())){
                all.add(album);
            }
        }
        return all;
    }
}