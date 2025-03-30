package org.project.Services.Music;

import org.project.Services.*;
import org.project.Entities.Music.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;
import java.util.Objects;

public class commentService implements service_interface<comment>, searchService_interface<comment> {

    dataStorage dataStorage;

    public commentService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public comment getById(String id) {
        for (comment comment: dataStorage.Comments){
            if (comment.getId().equals(id)){
                return comment;
            }
        }
        return null;
    }

    public void add(comment u) {
        dataStorage.Comments.add(u);
    }

    public void edit(comment u) {
        dataStorage.Comments.set(dataStorage.Comments.indexOf(u), u);
    }

    public void delete(comment u) {
        dataStorage.Comments.remove(u);
    }

    public ArrayList<comment> getAll() {
        return new ArrayList<>(dataStorage.Comments);
    }

    public ArrayList<comment> getBySearch(String search) {
        ArrayList<comment> all = new ArrayList<>();
        for (comment comment: dataStorage.Comments){
            if (Objects.equals(search, comment.getContent())){
                all.add(comment);
            }
        }
        return all;
    }
}