package org.project.Page;

import org.project.Entities.Music.song;
import org.project.Entities.Identity.user;
import org.project.Main;
import org.project.Page.page_abstract.*;
import org.project.DataStorage.dataStorage;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Scanner;

public class SongPage extends page {

    private final Scanner scanner;
    private final router router;
    dataStorage dataStorage;

    public SongPage(Scanner scanner, router router, dataStorage dataStorage) {
        this.scanner = scanner;
        this.router = router;
        this.dataStorage = dataStorage;
    }

    public void Initialize() {setName("SongPage");}

    public void showContent() {
        while (true) {
            System.out.println("Welcome to the Song Page");
            System.out.println("you want to continue or back to HomePage?");
            System.out.println("1. continue");
            System.out.println("2. back to HomePage");
            switch (scanner.nextInt()) {
                case 2: {
                    router.navigate("HomePage");
                }
                break;
                case 1: {
                    while (true) {
                        System.out.println("What would you want to do?");
                        System.out.println("1. View charts");
                        System.out.println("2. Search for a song");
                        switch (scanner.nextInt()) {
                            case 1: {
                                while (true) {
                                    ArrayList<AbstractMap.SimpleEntry<song, Integer>> pairs = Main.getServices.getSongService().charts();
                                    System.out.println("What song you want to view?  Enter your choice ");
                                    int choice = scanner.nextInt();
                                    if (choice > pairs.size() || choice < 1) {
                                        System.out.println("Invalid choice ");
                                        continue;
                                    }
                                    Main.getServices.getSongService().viewTheSong(pairs.get(choice - 1).getKey());
                                    System.out.println("Dou you want to view comments of this song? ");
                                    System.out.println("\n1. Yse ");
                                    System.out.println("2. No ");
                                    switch (scanner.nextInt()) {
                                        case 2: {
                                            break;
                                        }
                                        case 1: {
                                            Main.getServices.getCommentService().viewingComments(pairs.get(choice - 1).getKey());
                                            break;
                                        }
                                        default: {
                                            System.out.println("Invalid choice ");
                                            continue;
                                        }
                                    }
                                    System.out.println("Do you want to leave comment? ");
                                    System.out.println("\n1. Yes");
                                    System.out.println("2. No");
                                    switch (scanner.nextInt()) {
                                        case 2: {
                                            break;
                                        }
                                        case 1: {
                                            System.out.println("Wright your comment: ");
                                            String comment = scanner.next();
                                            Main.getServices.getUserService().creatComments(pairs.get(choice - 1).getKey(), comment, Main.account);
                                            break;
                                        }
                                        default: {
                                            System.out.println("Invalid choice ");
                                            continue;
                                        }
                                    }
                                    if (Main.account instanceof user) {
                                        System.out.println("Do you want to suggest editLyric for the song? ");
                                        System.out.println("\n1. Yes");
                                        System.out.println("2. No");
                                        switch (scanner.nextInt()) {
                                            case 2: {continue;}
                                            case 1: {
                                                System.out.println("Wright your suggestedEdit: ");
                                                String suggestedEdit = scanner.next();
                                                Main.getServices.getUserService().createEditLyrics(pairs.get(choice - 1).getKey(), suggestedEdit, (user) Main.account);
                                            }
                                            default: {System.out.println("Invalid choice ");continue;}
                                        }
                                    }
                                    System.out.println("Now what would you want to do? ");
                                    System.out.println("\n1. continue");
                                    System.out.println("2. another action");
                                    System.out.println("3. back to HomePage");
                                    switch (scanner.nextInt()) {
                                        case 1: {
                                            continue;
                                        }
                                        case 2: {
                                            break;
                                        }
                                        case 3: {
                                            router.navigate("HomePage");
                                        }
                                        break;
                                        default: {
                                            System.out.println("Invalid choice ");
                                            continue;
                                        }
                                    }
                                    break;
                                }
                            }
                            case 2: {
                                while (true) {
                                    System.out.println("Search the songTitle?");
                                    ArrayList<song> searchResult = Main.getServices.getSongService().getBySearch(scanner.next());
                                    if (searchResult.isEmpty()) {
                                        System.out.println("song not found");
                                    } else {
                                        System.out.println("\n which song did you want? ");
                                        int i = 1;
                                        for (song song : searchResult) {
                                            System.out.println(i + ": " + song.getTitle());
                                        }
                                        int choice = scanner.nextInt();
                                        if (choice > searchResult.size() || choice < 1) {
                                            System.out.println("Invalid choice ");
                                        } else {
                                            Main.getServices.getSongService().viewTheSong(searchResult.get(choice - 1));
                                            System.out.println("Dou you want to view comments of this song? ");
                                            System.out.println("\n1. Yse ");
                                            System.out.println("2. No ");
                                            switch (scanner.nextInt()) {
                                                case 2: {
                                                    break;
                                                }
                                                case 1: {
                                                    Main.getServices.getCommentService().viewingComments(searchResult.get(choice - 1));
                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Invalid choice ");
                                                    continue;
                                                }
                                            }
                                            System.out.println("Do you want to leave comment? ");
                                            System.out.println("\n1. Yes");
                                            System.out.println("2. No");
                                            switch (scanner.nextInt()) {
                                                case 2: {
                                                    break;
                                                }
                                                case 1: {
                                                    System.out.println("Wright your comment: ");
                                                    String comment = scanner.next();
                                                    Main.getServices.getUserService().creatComments(searchResult.get(choice - 1), comment, Main.account);
                                                    break;
                                                }
                                                default: {
                                                    System.out.println("Invalid choice ");
                                                    continue;
                                                }
                                            }
                                            if (Main.account instanceof user) {
                                                System.out.println("Do you want to suggest editLyric for the song? ");
                                                System.out.println("\n1. Yes");
                                                System.out.println("2. No");
                                                switch (scanner.nextInt()) {
                                                    case 2: {continue;}
                                                    case 1: {
                                                        System.out.println("Wright your suggestedEdit: ");
                                                        String suggestedEdit = scanner.next();
                                                        Main.getServices.getUserService().createEditLyrics(searchResult.get(choice - 1), suggestedEdit, (user) Main.account);
                                                    }
                                                    default: {System.out.println("Invalid choice ");continue;}
                                                }
                                            }
                                            System.out.println("Now what would you want to do? ");
                                            System.out.println("\n1. continue");
                                            System.out.println("2. another action");
                                            System.out.println("3. back to HomePage");
                                            switch (scanner.nextInt()) {
                                                case 1: {
                                                    continue;
                                                }
                                                case 2: {
                                                    break;
                                                }
                                                case 3: {
                                                    router.navigate("HomePage");
                                                }
                                                break;
                                                default: {
                                                    System.out.println("Invalid choice ");
                                                    continue;
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                            default: {
                                System.out.println("Invalid choice ");
                            }
                        }
                    }
                }
                default: {
                    System.out.println("Invalid choice ");
                }
            }
        }
    }
}