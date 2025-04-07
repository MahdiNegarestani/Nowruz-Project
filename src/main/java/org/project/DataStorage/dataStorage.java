package org.project.DataStorage;

import org.project.Entities.Identity.*;
import org.project.Entities.Music.*;

import java.util.ArrayList;

public class dataStorage {
    public ArrayList<account> Accounts = new ArrayList<>();
    public ArrayList<album> Albums = new ArrayList<>();
    public ArrayList<comment> Comments = new ArrayList<>();
    public ArrayList<comment_reaction> CommentReactions = new ArrayList<>();
    public ArrayList<edit_lyric_suggested> EditLyricsSuggests = new ArrayList<>();
    public ArrayList<song> Songs = new ArrayList<>();
    public ArrayList<account> AccountsRegisterd = new ArrayList<>();
}