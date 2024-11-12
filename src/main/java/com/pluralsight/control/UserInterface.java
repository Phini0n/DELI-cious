package com.pluralsight.control;

import com.pluralsight.model.userinterface.MenuState;

import java.util.Scanner;

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
        while (true) {
            if(firstRun) {
                System.out.println("Hello, welcome to the DELIcious deli! \nHow can we help you?\n");
                firstRun = false;
            }
            System.out.println("Home Screen" +
                    "1) New Order" +
                    "0) Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid entry.");
            }
        }
    }
}
