package org.project.Services;

import org.project.DataStorage.dataStorage;
import org.project.Services.Identity.*;
import org.project.Services.Music.*;

public class getServices {

    private dataStorage dataStorage;
    private userService userService;
    private artistService artistService;
    private adminService adminService;
    private songService songService;
    private albumService albumService;
    private commentService commentService;
    private comment_reactionService commentReactionService;
    private edit_lyric_suggestedService editLyricSuggestedService;

    public dataStorage getDataStorage() {
        if (dataStorage == null) {this.dataStorage = new dataStorage();}
        return this.dataStorage;
    }

    public userService getUserService() {
        if (userService == null) {this.userService = new userService(getDataStorage());}
        return this.userService;
    }

    public adminService getAdminService() {
        if (adminService == null) {adminService = new adminService(getDataStorage());}
        return adminService;
    }

    public artistService getArtistService() {
        if (artistService == null) {artistService = new artistService(getDataStorage());}
        return artistService;
    }

    public songService getSongService() {
        if (songService == null) {songService = new songService(getDataStorage());}
        return songService;
    }

    public albumService getAlbumService() {
        if (albumService == null) {albumService = new albumService(getDataStorage());}
        return albumService;
    }

    public commentService getCommentService() {
        if (commentService == null) {commentService = new commentService(getDataStorage());}
        return commentService;
    }

    public comment_reactionService getCommentReactionService() {
        if (commentReactionService == null) {commentReactionService = new comment_reactionService(getDataStorage());}
        return commentReactionService;
    }

    public edit_lyric_suggestedService getEditLyricsSuggestService() {
        if (editLyricSuggestedService == null) {
            editLyricSuggestedService = new edit_lyric_suggestedService(getDataStorage());
        }
        return editLyricSuggestedService;
    }
}