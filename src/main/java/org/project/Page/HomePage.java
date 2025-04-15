package org.project.Page;

import org.project.Page.page_abstract.*;
import org.project.DataStorage.dataStorage;
import org.project.Entities.Identity.account;

import java.util.Scanner;

public class HomePage extends page {

    private final Scanner scanner;
    private final router router;
    private final dataStorage dataStorage;

    public HomePage(Scanner scanner, router router, dataStorage dataStorage) {
        this.scanner = scanner;
        this.router = router;
        this.dataStorage = dataStorage;
    }

    public void Initialize() {setName("HomePage");}

    public void showContent() {
        while (true) {
            System.out.println("1. LoginPage");
            System.out.println("2. SignupPage");
            System.out.print("enter the desired route: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    router.navigate("LoginPage");
                    return;
                case "2":
                    router.navigate("SignupPage");
                    return;
                default:
                    router.navigate(input);
            }
        }
    }
}