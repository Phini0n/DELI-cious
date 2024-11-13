package com.pluralsight.control;

import com.pluralsight.model.Order;
import com.pluralsight.model.menuitem.Chips;
import com.pluralsight.model.menuitem.Drink;
import com.pluralsight.model.Size;
import com.pluralsight.model.MenuState;
import com.pluralsight.view.Display;

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
                display.showMessage("\nHello, welcome to the DELI-cious deli program!\n");
                firstRun = false;
            }

            display.showMenu(menuState);

            int choice = display.getUserInt();
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
                display.showMessageLine("\nInvalid entry, returning to home screen..");
        }
    }

    private void handleOrderScreen(int choice) {
        switch (choice) {

            case 1: // Add Signature Sandwich
                break;
            case 2: // Add Custom Sandwich
                processCustomSandwichRequest();
                break;
            case 3: // Add Drink
                processDrinkRequest();
                break;
            case 4: // Add Chips
                processChipsRequest();
                break;
            case 5: // Checkout
                processCheckoutRequest();
                break;
            case 0: // Cancel Order
                processCancelRequest();
                break;

            default:
                display.showMessageLine("\nInvalid entry, returning to order screen.");
        }
    }

    private void processDrinkRequest() {
        display.showMessageLine("Our Available Drink Sizes: Small, Medium, Large");
        display.showMessageLine("Please enter a size followed by your flavor. Ex: \"Small Cola\"");
        display.showMessage("\nEnter: ");

        String[] entry = display.getUserString().trim().split(" ");
        try {
            if (entry.length == 2) {
                order.addDrink(new Drink(Size.fromString(entry[0]), entry[1]));
            } else {
                display.showMessageLine("\nInvalid entry, returning to order screen.");
            }
        } catch (Exception e) {
            display.showMessageLine("\nError "  + e + " occurred with your input. Returning to order menu.");
        }
    }

    private void processChipsRequest() {
        display.showMessageLine("Please enter a flavor of chips you'd like.");
        display.showMessage("\nEnter: ");

        String entry = display.getUserString().trim();

        order.addChips(new Chips(entry));
    }

    private void processCustomSandwichRequest() {

    }

    private void processCheckoutRequest() {
        display.showMessageLine(order.toString()); // TODO: SHOW ORDER DETAILS AND PRICE
        display.showMessageLine("\n1) Confirm Order\n" +
                "0) Return to Order Menu");
        display.showMessage("\nEnter: ");
        switch (display.getUserInt()) {
            case 1:
                // TODO: CREATE RECEIPT HERE, INCLUDE FILE LOCATION
                display.showMessageLine("Your receipt was created in: ");
                break;
            case 0:
                break;
            default:
                display.showMessageLine("\nInvalid entry, returning to order screen.");
                break;
        }
    }

    private void processCancelRequest() {
        display.showMessageLine("\nAre you sure you want to cancel your order and return to the Home Screen? (y/n)");
        display.showMessage("\nEnter: ");
        switch (display.getUserString()) {
            case "y":
                // TODO: DELETE ORDER HERE
                display.showMessage("\nReturning to home menu . . .");
                menuState = MenuState.HOME_SCREEN;
                break;
            case "n":
                display.showMessageLine("\nYour order may resume.");
                break;
            default:
                display.showMessageLine("\nInvalid entry, returning to order screen.");
                break;
        }
    }
}
