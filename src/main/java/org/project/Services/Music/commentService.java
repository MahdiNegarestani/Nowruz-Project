package org.project.Services.Music;

import java.time.LocalDateTime;

import org.project.Main;
import org.project.Services.*;
import org.project.Services.Identity.userService;
import org.project.Entities.Music.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.AbstractMap;

public class commentService implements service_interface<comment>, searchService_interface<comment> {

    private dataStorage dataStorage;

    public commentService(dataStorage dataStorage) {this.dataStorage = dataStorage;}

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

    public void viewingComments(song song) {
        ArrayList<comment> temp = null;
        for (comment comment: getAll()){
            if (comment.getSongId().equals(song.getId())){
                temp.add(comment);
            }
        }
        if (temp == null){System.out.println("No comments found");}
        else {
            ArrayList<AbstractMap.SimpleEntry<comment, LocalDateTime>> pairs = new ArrayList<>();
            for (comment comment: temp){
                pairs.add(new AbstractMap.SimpleEntry<>(comment, comment.getReleaseDate()));
            }
            pairs.sort(java.util.Map.Entry.comparingByValue());
            for (AbstractMap.SimpleEntry<comment, LocalDateTime> pair: pairs){
                System.out.println(Main.getServices.getUserService().getById(pair.getKey().getUserId()).getUsername() + " (ReleaseDate: " + pair.getValue() + ") " + ": " + pair.getKey().getContent() + "\n");
            }

        }
    }
}