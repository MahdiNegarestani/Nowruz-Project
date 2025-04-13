package org.project.Page;

import org.project.Entities.Identity.user;
import org.project.Main;
import org.project.Page.page_abstract.*;
import org.project.DataStorage.dataStorage;
import org.project.Services.Identity.userService;
import org.project.Services.Identity.artistService;
import org.project.Services.Music.songService;
import org.project.Entities.Identity.artist;
import org.project.Entities.Music.edit_lyric_suggested;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UserPage extends page {

    private dataStorage dataStorage;
    private Scanner scanner;
    private router router;
    private userService userService;
    private artistService artistService;
    private songService songService;

    public UserPage(Scanner scanner, router router, dataStorage dataStorage) {
        this.scanner = scanner;
        this.router = router;
        this.dataStorage = dataStorage;
        this.userService = new userService(this.dataStorage);
        this.artistService = new artistService(this.dataStorage);
        this.songService = new songService(this.dataStorage);
    }

    public void Initialize() {setName("UserPage");}

    public void showContent() {
        while (true) {
            System.out.println("Welcome to your UserPage");
            System.out.println("What would you want to do?\n");
            System.out.println("1. back to HomePage");
            System.out.println("2. List of followingArtist");
            System.out.println("3. search for an artist");
            switch (scanner.nextInt()) {
                case 1: {router.navigate("HomePage");break;}
                case 2: {
                    while (true) {
                        ArrayList<artist> artistsList = userService.showFollowingArtistsNames((user) Main.account);
                        System.out.println("\n choose following artist\n");
                        int choice = scanner.nextInt();
                        if (choice < 1 || choice > artistsList.size()) {System.out.println("Invalid choice");}
                        else {
                            artist artist = artistsList.get(choice - 1);
                            System.out.println("\n Songs: \n");
                            artistService.showListOfSongs(artist);
                            System.out.println("\n Albums: \n");
                            artistService.showListOfAlbums(artist);
                            System.out.println("\n Status of your editSuggestedLyric: \n");
                            boolean exists = false;
                            for (edit_lyric_suggested suggested: artist.getLyricSuggestedList()) {
                                if (Objects.equals(suggested.getUserId(), Main.account.getId())) {
                                    System.out.println("Title of song: " + songService.getById(suggested.getSongId()).getTitle() + "\nEdit suggestion: " + suggested.getLyrics() + "\nStatus: " + suggested.getEditLyricsSuggestStatus() + "\n" + "\n");
                                    exists = true;
                                }
                            }
                            if (!exists) {System.out.println("You dont have any suggested songs\n");}
                            System.out.println("\n you want to continue or to choose another action? " + "\n1. continue" + "\n2. another action");
                            switch (scanner.nextInt()) {
                                case 1: continue;
                                case 2: {break;}
                                default: {System.out.println("Invalid choice");continue;}
                            }
                            break;
                        }
                    }
                }
                case 3: {
                    while (true) {
                        System.out.println("\n Search for an artist\n");
                        String search = scanner.nextLine();
                        artist artist = userService.searchArtist(search);
                        if (artist == null) {System.out.println("Artist not found");}
                        else {
                            boolean check = false;
                            user user = (user) Main.account;
                             for (String artistId: user.getArtistsFollowing().getArtistsId()) {
                                 if (artistId.equals(artist.getId())) {
                                     check = true;
                                     for (edit_lyric_suggested suggested: artist.getLyricSuggestedList()) {
                                         if (Objects.equals(suggested.getUserId(), Main.account.getId())) {
                                             System.out.println("Title of song: " + songService.getById(suggested.getSongId()).getTitle() + "\nEdit suggestion: " + suggested.getLyrics() + "\nStatus: " + suggested.getEditLyricsSuggestStatus() + "\n" + "\n");
                                         }
                                     }
                                 }
                             }
                             if (!check) {
                                 System.out.println("\nYou didnt follow this artist\n" + "Do you want to follow? " + "\n1. Yes" + "\n2. No");
                                 switch (scanner.nextInt()) {
                                     case 2: continue;
                                     case 1: {user.followArtist(artist.getId());break;}
                                     default: {System.out.println("Invalid choice");continue;}
                                 }
                             }
                             System.out.println("\nYou want to continue or to choose another action? " + "\n1. continue" + "\n2. choose another action");
                             switch (scanner.nextInt()) {
                                 case 1: continue;
                                 case 2: {break;}
                                 default: {System.out.println("Invalid choice");continue;}
                             }
                             break;
                        }
                    }
                }
                default: System.out.println("Invalid choice, please try again.");continue;
            }
        }
    }
}