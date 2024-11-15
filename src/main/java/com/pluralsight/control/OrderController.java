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
    private final SandwichController sandwichController;
    private final SidesController sidesController;

    public OrderController(MenuStateManager stateManager, SandwichController sandwichController,
                           SidesController sidesController) {
        this.stateManager = stateManager;
        this.sandwichController = sandwichController;
        this.sidesController = sidesController;
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
                stateManager.setMenuState(MenuState.ORDER_SCREEN);
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
                Drink newDrink = sidesController.processDrinkRequest();
                if (newDrink != null) {
                    order.addDrink(newDrink);
                }
                break;
            case 4: // Add Chips
                Chips newChips = sidesController.processChipsRequest();
                if (newChips != null) {
                    order.addChips(newChips);
                }
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

    private void processCustomSandwichRequest() {
        sandwichController.initializeSandwich();
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
        display.clearBuffer();
        display.showMessageLine("\nAre you sure you want to cancel your order and return to the Home Screen? (y/n)");
        display.showMessage("\nEnter: ");
        switch (display.getUserString()) {
            case "y":
                // TODO: DELETE ORDER HERE
                display.showMessageLine ("\nReturning to home menu . . .");
                order.orderClear();
                stateManager.setMenuState(MenuState.HOME_SCREEN);
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