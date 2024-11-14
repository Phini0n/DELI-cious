package com.pluralsight.view;

import com.pluralsight.model.menustate.MenuState;

import java.util.Scanner;

public class Display {
    private static final Scanner scanner = new Scanner(System.in);

    public void showMessage(String message) {
        System.out.print(message);
    }

    public void showMessageLine(String message) {
        System.out.println(message);
    }

    public void showMenu(MenuState menuState) {
        System.out.println();
        System.out.println(menuState.getTitle());
        System.out.println(menuState.getOptionsList());
        System.out.print("Enter: ");
    }

    public int getUserInt() {
        return scanner.nextInt();
    }

    public String getUserString() {
        return scanner.nextLine().toLowerCase();
    }

    public void clearBuffer() {
        scanner.nextLine();
    }
}
