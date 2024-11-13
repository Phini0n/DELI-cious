package com.pluralsight.view;

import java.util.Scanner;

public class Display {
    private static final Scanner scanner = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showMenu(String title, String options) {
        System.out.println(title);
        System.out.println(options);
        System.out.print("Enter: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public String getUserConfirmation() {
        scanner.nextLine(); // Clearing buffer
        return scanner.nextLine().toLowerCase();
    }
}
