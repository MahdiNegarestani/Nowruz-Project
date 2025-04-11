package org.project.Page;

import org.project.Page.page_abstract.*;
import org.project.DataStorage.dataStorage;
import org.project.Services.Identity.userService;
import java.util.Scanner;

public class UserPage extends page {

    private dataStorage dataStorage;
    private Scanner scanner;
    private router router;
    private userService userService;

    public UserPage(Scanner scanner, router router, dataStorage dataStorage) {
        this.scanner = scanner;
        this.router = router;
        this.dataStorage = dataStorage;
        this.userService = new userService(this.dataStorage);
    }

    public void Initialize() {setName("UserPage");}

    public void showContent() {
        while (true) {
            System.out.println("Welcome to your UserPage");
            System.out.println("What would you want to do?\n");
            System.out.println("1. back to HomePage");
            System.out.println("2. ");

        }
    }
}