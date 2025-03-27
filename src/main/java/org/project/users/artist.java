package org.project.Roles;

import java.util.ArrayList;
import java.util.ArrayList;
import org.json.*;

import javax.management.relation.Role;

public class artist extends role {

    private ArrayList<song> songs;  // we can handle it with json object
    private ArrayList<album> albums;

    public artist(String name, String username, String email) {super(name, username, email);}

    public void edit_lyric(song Song, String lyric){Song.lyric = lyric;}

    public void approve_edit(song Song, String submitted_edit){
        Song.lyric = submitted_edit;
        System.out.println("submitted edit approved");
    }

    public void reject_edit(song Song, String submitted_edit){System.out.println("submitted edit rejected");}

    public song creat_new_song(String title, album Album, artist Artist, String lyric, String genre, String tags, String releaseDate){
        song Song = new song(title, Album,  Artist, lyric, genre, tags, releaseDate);
        return Song;
    }

    public void displayRoleInfo(){}
}