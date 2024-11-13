package com.pluralsight.control;

import com.pluralsight.model.Order;
import com.pluralsight.model.userinterface.MenuState;
import com.pluralsight.view.Display;

import java.util.Scanner;

public class OrderController {
    private Order order;
    private Display display;

    private MenuState menuState;


    /**
     * init() initializes the order used within the following method(s).
     */
    private void init(){
        order = new Order();
        display = new Display();
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
                display.showMessage("Hello, welcome to the DELI-cious deli program! \nHow can we help you?");
                firstRun = false;
            }

            display.showMenu(menuState);

            int choice = display.getUserChoice();
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
                display.showMessage("Thank you! Exiting program. . .");
                System.exit(0);
                break;
            default:
                display.showMessage("Invalid entry.");
        }
    }

    private void handleOrderScreen(int choice) {
        switch (choice) {
            case 1: // Add Signature Sandwich
                break;
            case 2: // Add New Sandwich
                break;
            case 3: // Add Drink
                break;
            case 4: // Add Chips
                break;

            case 5: // Checkout
                // TODO: SHOW ORDER DETAILS AND PRICE
                display.showMessageLine("Are you ready to checkout and create a receipt? (y/n)");
                display.showMessage("Enter: ");
                switch (display.getUserConfirmation()) {
                    case "y":
                        // TODO: CREATE RECEIPT HERE, INCLUDE FILE LOCATION
                        display.showMessage("Your receipt was created in: ");
                        break;
                    case "n":
                        // TODO: DELETE ORDER HERE
                        display.showMessage("Deleted order, returning to home screen . . .");
                        menuState = MenuState.HOME_SCREEN;
                        break;
                }
                break;

            case 0: // Cancel Order
                display.showMessageLine("Are you sure you want to cancel your order and return to the Home Screen? (y/n)");
                display.showMessage("Enter: ");
                switch (display.getUserConfirmation()) {
                    case "y":
                        // TODO: DELETE ORDER HERE
                        display.showMessage("\nReturning to home menu . . .");
                        menuState = MenuState.HOME_SCREEN;
                        break;
                    case "n":
                        display.showMessage("Your order may resume.");
                        break;
                }
                break;

            default:
                display.showMessage("Invalid entry.");
        }
    }

    private void processDrinkRequest() {

    }

    private void processSandwichRequest() {

    }
}
