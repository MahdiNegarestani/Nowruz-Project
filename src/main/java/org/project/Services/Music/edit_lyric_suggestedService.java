package org.project.Services.Music;

import org.project.Services.*;
import org.project.Entities.Music.*;
import org.project.DataStorage.dataStorage;
import java.util.ArrayList;

public class edit_lyric_suggestedService implements service_interface<edit_lyric_suggested> {

    dataStorage dataStorage;

    public edit_lyric_suggestedService(dataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public edit_lyric_suggested getById(String id) {
        for (edit_lyric_suggested edit_lyric_seggested: dataStorage.EditLyricsSuggests){
            if (edit_lyric_seggested.getId().equals(id)){
                return edit_lyric_seggested;
            }
        }
        return null;
    }

    public void add(edit_lyric_suggested u) {
        dataStorage.EditLyricsSuggests.add(u);
    }

    public void edit(edit_lyric_suggested u) {
        dataStorage.EditLyricsSuggests.set(dataStorage.CommentReactions.indexOf(u), u);
    }

    public void delete(edit_lyric_suggested u) {
        dataStorage.CommentReactions.remove(u);
    }

    public ArrayList<edit_lyric_suggested> getAll() {
        return new ArrayList<>(dataStorage.EditLyricsSuggests);
    }
}