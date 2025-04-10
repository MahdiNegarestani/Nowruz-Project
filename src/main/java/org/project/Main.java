package org.project;

import java.util.Scanner;
import org.project.DataStorage.dataStorage;
import org.project.Page.page_abstract.*;
import org.project.Page.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner;
    static dataStorage dataStorage;

    public static void configure(application app) {
        scanner = new Scanner(System.in);
        dataStorage = new dataStorage();
        addRoutes(app);
    }

    private static void addRoutes(application app) {
        app.getRouter().addRoute("Home",new HomePage(scanner, app.getRouter(), dataStorage));
        app.getRouter().addRoute("SignUp",new HomePage(scanner, app.getRouter(), dataStorage));
    }

    public static void main(String[] args) {
        application app = application.CreateDefault();
        configure(app);
        app.run();
    }
}