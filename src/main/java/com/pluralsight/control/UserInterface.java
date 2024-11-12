package com.pluralsight.control;

import com.pluralsight.model.userinterface.MenuState;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    private MenuState menuState;


    /**
     * init() initializes the variables used within the display method(s).
     */
    private void init(){

    }

    public void display() {
        // Initialize variables
        init();

        handleDisplay();
    }

    private void handleDisplay() {
        boolean firstRun = true;
        menuState = MenuState.HOME_SCREEN;
        while (true) {
            if(firstRun) {
                System.out.println("Hello, welcome to the DELI-cious deli program! \nHow can we help you?\n");
                firstRun = false;
            }

            // Printing out the Home Screen menu state and its options.
            System.out.println(menuState.getTitle());
            System.out.print(menuState.getOptionsList());

            int choice = scanner.nextInt();
            switch (menuState) {
                case HOME_SCREEN -> handleHomeScreen(choice);
            }

        }
    }

    private void handleHomeScreen(int choice) {
        switch (choice) {
            case 1:
                break;
            case 2:
                break;
            case 0:
                System.out.println("Thank you! Exiting program. . .");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid entry.");
        }
    }
}
