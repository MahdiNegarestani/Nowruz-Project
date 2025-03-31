package org.project.Entities.Identity;

import org.project.Entities.entity;

import java.util.ArrayList;

public class artistsFollowing extends entity {

    private String userId;
    private ArrayList<String> artistsId;

    public artistsFollowing() {}

    public artistsFollowing(String userId, ArrayList<String> artistsId){
        this.userId = userId;
        this.artistsId = artistsId;
    }

    public String getUserId() {return this.userId;}

    public void setUserId(String userId) {this.userId = userId;}

    public ArrayList<String> getArtistsId() {return this.artistsId;}

    public void addArtistId(String artistId) {this.artistsId.add(artistId);}
}