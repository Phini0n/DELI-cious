package com.pluralsight.control;

import com.pluralsight.model.Order;
import com.pluralsight.model.menuitem.Chips;
import com.pluralsight.model.menuitem.Drink;
import com.pluralsight.model.menuitem.sandwich.Sandwich;
import com.pluralsight.model.menustate.MenuState;
import com.pluralsight.view.Display;

public class OrderController {
    private final Order order;
    private final Display display;
    private final SidesController sidesController;
    private MenuState menuState;
    private final SandwichController sandwichController;
    public OrderController() {
        this.sidesController = new SidesController();
        this.sandwichController = new SandwichController(menuState);
        this.display = new Display();
        this.order = new Order();
        this.menuState = MenuState.HOME_SCREEN;
    }

    public void display() {
        display.showMessageLine("Welcome to the DELI-cious Deli!");
        handleMenus();
    }

    private void handleMenus() {
        while (true) {
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
            case 1 -> menuState = MenuState.ORDER_SCREEN;
            case 0 -> exitProgram();
            default -> display.showMessageLine("Invalid entry, returning to home screen.");
        }
    }

    private void handleOrderScreen(int choice) {
        switch (choice) {
            case 1 -> processSignatureSandwich();
            case 2 -> processCustomSandwich();
            case 3 -> processDrink();
            case 4 -> processChips();
            case 5 -> processCheckout();
            case 0 -> cancelOrder();
            default -> display.showMessageLine("Invalid entry, returning to order screen.");
        }
    }

    private void processDrink() {
        Drink newDrink = sidesController.processDrinkRequest();
        if (newDrink != null) {
            order.addDrink(newDrink);
        }
        menuState = MenuState.ORDER_SCREEN;
    }

    private void processChips() {
        Chips newChips = sidesController.processChipsRequest();
        if (newChips != null) {
            order.addChips(newChips);
        }
        menuState = MenuState.ORDER_SCREEN;
    }

    private void processCheckout() {
        display.showMessageLine(order.toString()); // TODO: SHOW ORDER DETAILS AND PRICE
        display.showMessageLine("""

                1) Confirm Order
                0) Return to Order Menu""");
        display.showMessage("\nEnter: ");
        switch (display.getUserInt()) {
            case 1:
                // TODO: CREATE RECEIPT HERE, INCLUDE FILE LOCATION
                display.showMessageLine("Your receipt was created in: ");
                break;
            case 0:
                menuState = MenuState.ORDER_SCREEN;
                break;
            default:
                display.showMessageLine("\nInvalid entry, returning to order screen.");
                break;
        }
    }

    private void cancelOrder() {
        display.showMessageLine("\nAre you sure you want to cancel your order and return to the Home Screen? (y/n)");
        display.showMessage("\nEnter: ");
        display.clearBuffer();
        switch (display.getUserString()) {
            case "y":
                // TODO: DELETE ORDER HERE
                display.showMessageLine ("\nReturning to home menu . . .");
                order.orderClear();
                menuState = MenuState.HOME_SCREEN;
                break;
            case "n":
                display.showMessageLine("\nYour order may resume.");
                menuState = MenuState.ORDER_SCREEN;
                break;
            default:
                display.showMessageLine("\nInvalid entry, returning to order screen.");
                break;
        }
    }

    private void processCustomSandwich() {
        sandwichController.initializeSandwich();
        Sandwich sandwich = sandwichController.getFinalSandwich();
        if (sandwich != null) {
            order.addSandwich(sandwich);
        }
    }

    private void processSignatureSandwich() {

    }

    private void exitProgram() {
        display.showMessage("Thank you! Exiting program . . .");
        System.exit(0);
    }
}