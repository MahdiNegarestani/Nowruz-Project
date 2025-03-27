package org.project.Roles;

import javax.management.relation.Role;
import java.util.ArrayList;

public class user extends role {
    private ArrayList<artist> artistFollowing;
    private String comments;

    public user(String name, String username, String email) {super(name, username, email);}

    public void follow_artist(artist Artist){artistFollowing.add(Artist);}

    public void setComments(String comments){this.comments = comments;}

    public void send_comments(song Song){Song.comments.add(this.comment);}

    public String view_songLyric(song Song){return Song.lyric;}

    public void suggestEdit(song Song, String suggestedEdit){song.artist.user_submitted_edits.add(suggestedEdit);}  // we can handle it with jsone object

    public void userInterface(){
        int i = 1;
        for (artist Artist: artistFollowing){
            System.out.println(i + Artist);
            i ++;
        }
    }

    public void displayRoleInfo(){}
}