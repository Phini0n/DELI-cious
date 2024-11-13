package com.pluralsight.control;

import com.pluralsight.model.Order;
import com.pluralsight.model.userinterface.MenuState;

import java.util.Scanner;

public class OrderController {
    private static final Scanner scanner = new Scanner(System.in);

    private MenuState menuState;


    /**
     * init() initializes the order used within the following method(s).
     */
    private void init(){
        Order order = new Order();
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
            System.out.println(menuState.getOptionsList());
            System.out.print("Enter: ");

            int choice = scanner.nextInt();
            switch (menuState) {
                case HOME_SCREEN -> handleHomeScreen(choice);
                case ORDER_SCREEN -> handleOrderScreen(choice);
            }
        }
    }

    private void handleHomeScreen(int choice) {
        switch (choice) {
            case 1: // New Order
                menuState = MenuState.ORDER_SCREEN;
                break;
            case 0: // Exit
                System.out.println("Thank you! Exiting program. . .");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid entry.");
        }
    }

    private void handleOrderScreen(int choice) {
        switch (choice) {
            case 1: // Add Sandwich
                break;
            case 2: // Add Drink
                break;
            case 3: // Add Chips
                break;

            case 4: // Checkout
                System.out.println("Are you ready to checkout and create a receipt? (y/n)");
                System.out.print("Enter: ");
                scanner.nextLine(); // Clearing buffer
                switch (scanner.nextLine().toLowerCase()) {
                    case "y":
                        // TODO: CREATE RECEIPT HERE, INCLUDE FILE LOCATION
                        System.out.println("Your receipt was created in: ");
                    case "n":
                        // TODO: DELETE ORDER HERE
                        System.out.println("Deleted order, returning to order menu . . .");
                }
                break;

            case 0: // Cancel Order
                System.out.println("Are you sure you want to cancel your order? (y/n)");
                System.out.print("Enter: ");
                scanner.nextLine(); // Clearing buffer
                switch (scanner.nextLine().toLowerCase()) {
                    case "y":
                        System.out.println("Returning to order menu . . .");
                        menuState = MenuState.HOME_SCREEN;
                        break;
                    case "n":
                        System.out.println("Your order may resume.");
                        break;
                }
                break;

            default:
                System.out.println("Invalid entry.");
        }
    }

    private void processDrinkRequest() {

    }

    private void processSandwichRequest() {

    }
}
