package org.project;

import java.util.Scanner;
import org.project.Services.*;
import org.project.Page.page_abstract.*;
import org.project.Page.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static Scanner scanner;
    static getServices services;

    public static void configure(application app) {
        scanner = new Scanner(System.in);
        services = new getServices();
        addRoutes(app);
    }

    private static void addRoutes(application app) {
        app.getRouter().addRoute("Home",new HomePage(scanner, app.getRouter()));
    }

    public static void main(String[] args) {
        application app = application.CreateDefault();
        configure(app);
        app.run();
    }
}