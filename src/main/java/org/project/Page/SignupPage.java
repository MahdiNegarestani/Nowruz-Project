package org.project.Page;

import org.project.Page.page_abstract.*;
import org.project.DataStorage.dataStorage;
import org.project.Services.Identity.accountManager;
import org.project.Enums.roles;
import org.project.IDR;

import java.util.Scanner;

public class SignupPage extends page {

    private final Scanner scanner;
    private final router router;
    private final dataStorage dataStorage;
    private accountManager accountManager;

    public SignupPage(Scanner scanner, router router, dataStorage dataStorage) {
        this.scanner = scanner;
        this.router = router;
        this.dataStorage = dataStorage;
        this.accountManager = new accountManager(this.dataStorage);
    }

    public void Initialize() {setName("SignupPage");}

    public void showContent() {
        while (true) {
            System.out.println("Welcome to the Signup Page");
            System.out.println("you want to continue or back to Home Page?");
            System.out.println("1. continue");
            System.out.println("2. back to Home Page");
            switch (scanner.nextInt()) {
                case 2: {router.navigate("Home Page");}break;
                case 1: {
                    while (true) {
                        System.out.println("Enter your Name: ");
                        String name = scanner.nextLine();
                        System.out.println("Enter Username: ");
                        String username = scanner.nextLine();
                        System.out.println("Enter Password: ");
                        String password = scanner.nextLine();
                        System.out.println("Enter Email: ");
                        String email = scanner.nextLine();
                        System.out.println("Enter your Age: ");
                        int age = scanner.nextInt();
                        roles role;
                        while (true){
                            System.out.println("Choose your role: ");
                            System.out.println("1. User");
                            System.out.println("2. Artist");
                            int choice = scanner.nextInt();
                            switch (choice) {
                                case 1: role = roles.USER; break;
                                case 2: role = roles.ARTIST; break;
                                default: System.out.println("Invalid choice, please try again."); continue;
                            }
                            break;
                        }
                        System.out.println("Are you sure about the information you entered? ");
                        System.out.println("1. Yes");
                        System.out.println("2. No");
                        switch (scanner.nextInt()) {
                            case 1:break;
                            case 2: continue;
                            default:break;
                        }
                        System.out.println("\nyou want to continue or back to HomePage? ");
                        System.out.println("1. continue");
                        System.out.println("2. back to HomePage");
                        switch (scanner.nextInt()) {
                            case 1:break;
                            case 2: this.router.navigate("HomePage");break;
                            default: break;
                        }

                        IDR IDR = accountManager.signup(name, username, password, email, age, role);
                        String message = IDR.getMessage();
                        while (true) {
                            System.out.println(message);
                            if (message.equals("username is already taken")) {
                                System.out.println(message + "\nEnter another Username: ");
                                String newUsername = scanner.nextLine();
                                IDR = accountManager.signup(newUsername, username, password, email, age, role);
                                message = IDR.getMessage();
                            } else {break;}
                        }
                        router.navigate("HomePage");
                    }
                }
                default: System.out.println("Invalid choice, please try again.");continue;
            }
            break;
        }
    }

}