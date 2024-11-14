package com.pluralsight.control;

import com.pluralsight.model.Order;
import com.pluralsight.model.menuitem.Chips;
import com.pluralsight.model.menuitem.Drink;
import com.pluralsight.model.Size;
import com.pluralsight.model.menustate.MenuState;
import com.pluralsight.model.menustate.Observer;
import com.pluralsight.service.MenuStateManager;
import com.pluralsight.view.Display;

public class OrderController implements Observer {
    private Order order;
    private Display display;
    private MenuState menuState;
    private final MenuStateManager stateManager;

    public OrderController(MenuStateManager stateManager) {
        this.stateManager = stateManager;
        stateManager.addObserver(this);
    }

    /**
     * init() initializes the order used within the following method(s).
     */
    private void init(){
        order = new Order();
        display = new Display();
        stateManager.addObserver(this);
    }

    public void display() {
        // Initialize variables
        init();

        handleDisplay();
    }

    private void handleDisplay() {
        boolean firstRun = true;
        stateManager.setMenuState(MenuState.HOME_SCREEN);
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
                update(MenuState.ORDER_SCREEN);
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
                processSignatureSandwichRequest();
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
        display.showMessageLine("""
                Our Available Drink Sizes: Small, Medium, Large:
                Please enter a size followed by your flavor. Ex: Small Cola
                Enter 0 to stop ordering a Drink.
                
                """);
        display.clearBuffer();
        while (true) {
            display.showMessage("Enter: ");
            try {
                String input = display.getUserString().trim();

                if (input.isEmpty()) {
                    display.showMessageLine("Input is empty. Please try again, or enter 0 to exit.");
                    continue;
                }

                String[] entry = input.split(" ");

                if (entry.length == 2) {
                    Size size = Size.fromString(entry[0]);

                    // Checking if size is correct
                    if (size != null) {
                        order.addDrink(new Drink(size, entry[1]));
                        return;
                    } else {
                        display.showMessageLine("Our sizes are Small, Medium, and Large. " +
                                "Please try again, or enter 0 to exit.");
                    }

                // Checking if user wants to exit
                } else if (entry[0].equals("0")) {
                    display.showMessageLine("Returning to Order menu.");
                    return;

                } else {
                    display.showMessageLine("\nError, wrong amount of arguments. " +
                            "Please try again, or enter 0 to exit.");
                }

            } catch (Exception e) {
                display.showMessageLine("\nError "  + e + " occurred with your input. " +
                        "Please try again, or enter 0 to exit.");
            }
        }
    }

    private void processChipsRequest() {
        display.showMessageLine("""
                Please enter any flavor of chips you'd like.
                Enter 0 to stop ordering Chips.
                
                Enter:\s""");

        display.clearBuffer();

        String entry = display.getUserString().trim();
        if (entry.equals("0")) {
            display.showMessageLine("Returning to Order menu.");
        } else {
            order.addChips(new Chips(entry));
        }
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

    private void processSignatureSandwichRequest() {

    }

    @Override
    public void update(MenuState menuState) {
        this.menuState = menuState;
    }
}
