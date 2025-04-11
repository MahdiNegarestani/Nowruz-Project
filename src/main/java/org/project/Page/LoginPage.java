package org.project.Page;

import org.project.Entities.Identity.artist;
import org.project.Main;
import org.project.Page.page_abstract.*;
import org.project.DataStorage.dataStorage;
import org.project.Services.Identity.accountManager;
import org.project.Entities.Identity.account;
import org.project.Entities.Identity.user;

import java.util.Scanner;

public class LoginPage extends page {

    private final Scanner scanner;
    private final accountManager accountManager;
    private final router router;
    private final dataStorage dataStorage;

    public LoginPage(Scanner scanner, router router, dataStorage dataStorage) {
        this.scanner = scanner;
        this.router = router;
        this.dataStorage = dataStorage;
        this.accountManager = new accountManager(this.dataStorage);
    }

    public void Initialize() {setName("LoginPage");}

    public void showContent() {
        while (true) {
            System.out.println("Welcome to the Login Page");
            System.out.println("you want to continue or back to HomePage?");
            System.out.println("1. continue");
            System.out.println("2. back to HomePage");
            switch (scanner.nextInt()) {
                case 2: {router.navigate("HomePage");}break;
                case 1: {
                    while (true) {
                        System.out.println("Enter your username");
                        String username = scanner.next();
                        System.out.println("Enter your password");
                        String password = scanner.next();
                        account account1 = accountManager.Login(username, password);
                        if (account1 == null) {continue;}
                        System.out.println("You want to continue or back to Home Page");
                        System.out.println("1. continue");
                        System.out.println("2. back to Home Page");
                        switch (scanner.nextInt()) {
                            case 2: {router.navigate("HomePage");}break;
                            case 1: {break;}
                        }
                        switch (account1.getRole()) {
                            case USER: {
                                Main.account = new user(account1.getName(), account1.getUsername(), account1.getPassword(), account1.getEmail(), account1.getAge(), account1.getRole());
                                router.navigate("UserPage");
                                break;
                            }
                            case ARTIST: {
                                Main.account = new artist(account1.getName(), account1.getUsername(), account1.getPassword(), account1.getEmail(), account1.getAge(), account1.getRole());
                                router.navigate("ArtistPage");
                                break;
                            }
                        }
                        break;
                    }
                }
                default: System.out.println("Invalid choice, please try again.");continue;
            }
            break;
        }
    }
}