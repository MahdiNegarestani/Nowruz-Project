package org.project.Page;

import org.project.Page.page_abstract.*;

import java.util.Scanner;

public class HomePage extends page {

    private final Scanner scanner;
    private final router router;

    public HomePage(Scanner scanner, router router) {
        this.scanner = scanner;
        this.router = router;
    }

    public void Initialize() {setName("HomePage");}

    public void showContent() {
        while (true) {
            System.out.println("1. Login");
            System.out.println("2. SignUp");
            System.out.print("enter the desired route: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    router.navigate("Login");
                    return;
                case "2":
                    router.navigate("Signup");
                    return;
                default:
                    router.navigate(input);
            }
        }
    }
}