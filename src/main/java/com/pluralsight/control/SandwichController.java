package com.pluralsight.control;

import com.pluralsight.model.menuitem.sandwich.toppings.*;
import com.pluralsight.model.menustate.MenuState;
import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.sandwich.Sandwich;
import com.pluralsight.view.Display;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SandwichController {
    private Display display = new Display();
    private MenuState menuState;
    private ToppingsController toppingsController;
    // Sandwich Variables
    Sandwich finalSandwich;
    private Size sandwichSize = Size.SMALL;
    private boolean isToasted;
    private boolean isCancelled; // Determines if the initialize process will continue, or not.
    private boolean isSignature; // Determines if this Sandwich is signature, or not.
    private String bread;
    private List<Topping> toppings = new ArrayList<Topping>();

    public SandwichController(MenuState menuState) {
        this.menuState = menuState;
        this.toppingsController = new ToppingsController(menuState);
    }

    // Using Custom Sandwich
    public void initializeSandwich() {
        // First questions
        isCancelled = false;
        processSizeRequest();
        processIsToastedRequest();
        processBreadRequest();
        startSandwichBuilder();
    }

    // Using Signature Sandwich
    public void initializeSandwich(Sandwich sandwich) {
        sandwichSize = sandwich.getSize();
        isToasted = sandwich.isToasted();
        isSignature = true;
        bread = sandwich.getBread();
        toppings = sandwich.getToppings();
        startSandwichBuilder();
    }

    public void startSandwichBuilder() {
        toppings.clear();
        // Initial Screen
        menuState = MenuState.SANDWICH_SCREEN;

        while (true) {

            if (menuState == MenuState.ORDER_SCREEN) {
                return;
            }

            if (isCancelled) {
                display.showMessage("Sandwich process was cancelled. Returning to Order menu.");
                return;
            }

            if (!isCancelled && menuState == MenuState.SANDWICH_SCREEN) {
                display.showMessageLine(showCurrentSandwich());
            }

            display.showMenu(menuState);

            int choice = display.getUserInt();

            switch (menuState) {
                case SANDWICH_SCREEN -> handleSandwichScreen(choice);
                case TOPPINGS_SCREEN -> handleToppingsScreen(choice);
                case ORDER_SCREEN -> {
                    display.clearBuffer();
                    return;
                }
            }
        }
    }

    private void handleSandwichScreen(int choice) {
        switch (choice) {
            case 1: // Bread Type
                display.clearBuffer();
                processBreadRequest();
                processIsToastedRequest();
                break;
            case 2: // Sandwich Size
                processSizeRequest();
                break;
            case 3: // Toppings
                menuState = MenuState.TOPPINGS_SCREEN;
                break;
            case 4: // Remove Topping
                display.showMessageLine("Would you like to remove a topping?\n" +
                "Enter 0 to exit.");
                display.showMessageLine(showAllToppings((ArrayList<Topping>) toppings));
                display.showMessage("Enter: ");

                display.clearBuffer();
                String input = display.getUserString();
                if (input != null) {
                    removeToppingsByName(input);
                }

                break;
            case 5: // Finish Sandwich
                finalSandwich = new Sandwich(sandwichSize, isToasted, bread, (ArrayList<Topping>) toppings);
                display.showMessage("Your sandwich was added to your order.");
                menuState = MenuState.ORDER_SCREEN;
                break;
            case 0: // Exit
                display.clearBuffer();
                display.showMessageLine("\nAre you sure you want to cancel your sandwich and return to the Order Screen? (y/n)");
                display.showMessage("\nEnter: ");
                switch (display.getUserString()) {
                    case "y":
                        display.showMessageLine("\nReturning to order menu . . .");
                        isCancelled = true;
                        menuState = MenuState.ORDER_SCREEN;
                        break;
                    case "n":
                        display.showMessageLine("\nYour sandwich building may resume.");
                        break;
                    default:
                        display.showMessageLine("\nInvalid entry, returning to Sandwich Builder screen.");
                        break;
                }
                break;
            default:
                display.showMessageLine("\nInvalid entry, returning to home screen..");
        }
    }

    public void handleToppingsScreen(int choice) {
        Topping newTopping = toppingsController.handleToppingsScreen(choice);
        if (newTopping != null) {
            toppings.add(newTopping);
        }
        menuState = MenuState.SANDWICH_SCREEN;
    }

    private void processSizeRequest() {
        if (!isCancelled) {
            display.showMessageLine("""
                    Enter your size (4", 8", 12"):
                    Enter 0 to stop Sandwich Building.
                                    
                    """);
            display.clearBuffer();
            while (true) {
                display.showMessage("Enter: ");
                try {
                    String input = display.getUserString().trim();

                    if (input.isEmpty()) {
                        display.showMessageLine("Input is empty. Please try again, or enter 0 to exit.");
                    } else {
                        Size size = Size.sandwichSizeFromString(input);

                        if (input.equals("0")) {
                            display.showMessageLine("Exiting Sandwich Building interface . . .");
                            isCancelled = true;
                            return;

                        } else if (size != null) {
                            sandwichSize = size;
                            return;
                        } else {
                            display.showMessageLine("Our sizes are 4\", 8\", and 12\".");
                        }
                    }
                } catch (Exception e) {
                    display.showMessageLine("\nError " + e + " occurred with your input. " +
                            "Please try again, or enter 0 to exit.");
                }
            }
        }
    }

    private void processIsToastedRequest() {
        if (!isCancelled) {
            display.showMessage("""
                    Would you like your bread toasted? (Y/N)
                    Enter 0 to stop Sandwich Building.
                                    
                    """);
            while (true) {
                display.showMessage("Enter: ");
                String input = display.getUserString();
                switch (input.toLowerCase()) {
                    case "y":
                        isToasted = true;
                        return;
                    case "n":
                        isToasted = false;
                        return;
                    case "0":
                        display.showMessage("Exiting Sandwich Building interface. . . ");
                        isCancelled = true;
                        return;
                    default:
                        display.showMessageLine("Invalid input. Please try again, or enter 0 to exit.");
                }
            }
        }
    }

    private void processBreadRequest() {
        if (!isCancelled) {
            display.showMessageLine("""
                    Enter your bread (White, Wheat, Rye, Wrap)
                    Enter 0 to stop Sandwich Building.
                                    
                    """);
            while (true) {
                display.showMessage("Enter: ");
                try {
                    String input = display.getUserString();
                    switch (input.toLowerCase()) {
                        case "white":
                            display.showMessageLine("The bread type is now white.");
                            bread = input;
                            return;
                        case "wheat":
                            display.showMessageLine("The bread type is now wheat.");
                            bread = input;
                            return;
                        case "rye":
                            display.showMessageLine("The bread type is now rye.");
                            bread = input;
                            return;
                        case "wrap":
                            display.showMessageLine("The bread type is now wrap.");
                            bread = input;
                            return;
                        case "0":
                            display.showMessage("Exiting Sandwich Building interface. . . ");
                            isCancelled = true;
                            return;
                        default:
                            display.showMessageLine("Invalid input. Please try again, or enter 0 to exit.");
                            break;
                    }
                } catch (Exception e) {
                    display.showMessageLine("\nError " + e + " occurred with your input. Please try again, or enter 0 to exit.");
                }
            }
        }
    }

    private String showCurrentSandwich() {
        StringBuilder allToppings = new StringBuilder();
        for (Topping topping : toppings) {
            if (topping != null) {
                allToppings.append(topping.getToppingName()).append(" ");
            }
        }

        String toastedStatus = isToasted ? " toasted " : " ";
        String signatureStatus = isSignature ? "Signature:  with" : "";


        return "\nYour current sandwich:\n" +
                signatureStatus + sandwichSize.sandwichSizeName + toastedStatus + bread +
                " with " + allToppings.toString();
    }

    private String showAllToppings(ArrayList<Topping> toppings) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < toppings.size(); i++) {
            sb.append(toppings.get(i).getToppingName());
            if (i != toppings.size()) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    private void removeToppingsByName(String searchedTopping) {
        toppings.removeIf(topping -> topping.getToppingName().trim().equalsIgnoreCase(searchedTopping));
    }

    public Sandwich getFinalSandwich() {
        return finalSandwich;
    }
}