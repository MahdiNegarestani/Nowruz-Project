package org.project.Services.Music;

import org.project.Services.*;
import org.project.Entities.Music.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;

public class comment_reactionService implements service_interface<comment_reaction> {

    dataStorage dataStorage;

    public comment_reactionService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public comment_reaction getById(String id) {
        for (comment_reaction comment_reaction: dataStorage.CommentReactions){
            if (comment_reaction.getId().equals(id)){
                return comment_reaction;
            }
        }
        return null;
    }

    public void add(comment_reaction u) {
        dataStorage.CommentReactions.add(u);
    }

    public void edit(comment_reaction u) {
        dataStorage.CommentReactions.set(dataStorage.CommentReactions.indexOf(u), u);
    }

    public void delete(comment_reaction u) {
        dataStorage.CommentReactions.remove(u);
    }

    public ArrayList<comment_reaction> getAll() {
        return new ArrayList<>(dataStorage.CommentReactions);
    }
}