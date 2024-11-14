package com.pluralsight.control;

import com.pluralsight.model.MenuState;
import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.sandwich.Bread;
import com.pluralsight.model.menuitem.sandwich.Sandwich;
import com.pluralsight.model.menuitem.sandwich.toppings.Topping;
import com.pluralsight.view.Display;

import java.util.ArrayList;
import java.util.List;

public class SandwichController {
    private Display display = new Display();
    private MenuState menuState;

    // Sandwich Variables
    Sandwich sandwich;
    private Size sandwichSize;
    private boolean isToasted;
    private boolean isCancelled; // Determines if the initalize process will continue, or not.
    private Bread bread;
    private List<Topping> toppings = new ArrayList<Topping>();
    private List<Object> cart = new ArrayList<>();

    // Using Custom Sandwich
    private void initializeSandwich() {
        isCancelled = false;
        processSizeRequest();
        processIsToastedRequest();
        processBreadRequest();
        if (isCancelled) {
            display.showMessage("Sandwich process was cancelled. Returning to Order menu.");
        }
    }

    // Using Signature Sandwich
    private void initializeSandwich(Sandwich sandwich) {
        // TODO: Implement this.
    }

    private void handleSandwichScreen() {
        display.showMessageLine("""
                Sandwich Builder
                1) Bread
                2) Toppings
                
                Enter:\s
                """);
    }

    public Sandwich handleToppingsScreen() {
        // Toppings
        display.showMessageLine("""
                Toppings Builder
                1) Meat
                2) Cheese
                3) Other toppings
                4) Sauces
                
                Enter:\s
                """);
        return null;
    }

    private void processSizeRequest() {
        if (!isCancelled) {
            display.showMessageLine("""
                Enter your size (Small, Medium, Large):
                Enter 0 to stop Sandwich Building.
                
                """);
            while (true) {
                display.showMessage("Enter: ");
                try {
                    String input = display.getUserString();
                    if (input.equals("0")) {
                        display.showMessage("Exiting Sandwich Building interface. . . ");
                        isCancelled = true;
                        return;
                    }
                    sandwichSize = Size.fromString(input);
                } catch (Exception e) {
                    display.showMessageLine("\nError "  + e + " occurred with your input. " +
                            "Please try again, or enter 0 to exit.");
                }
            }
        }
    }

    private void processIsToastedRequest() {
        if (!isCancelled) {
            display.showMessage("""
                Would you like your bread toasted? (Y/N):
                Enter 0 to stop Sandwich Building.
                
                """);
            while (true) {
                display.showMessage("Enter: ");
                String input = display.getUserString();
                switch (input.toLowerCase()) {
                    case "y":
                        isToasted = true;
                        break;
                    case "n":
                        isToasted = false;
                        break;
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
                Enter your bread (White, Wheat, Rye, Wrap):
                Enter 0 to stop Sandwich Building.
                
                """);
            while (true) {
                display.showMessage("Enter: ");
                try {
                    String input = display.getUserString();
                    if (input.equals("0")) {
                        display.showMessage("Exiting Sandwich Building interface. . . ");
                        isCancelled = true;
                        return;
                    }
                    bread = Bread.fromString(input);
                } catch (Exception e) {
                    display.showMessageLine("\nError "  + e + " occurred with your input. Please try again, or enter 0 to exit.");
                }
            }
        }
    }

    public String showCurrentSandwich(ArrayList<Object> cart) {
        return "";
    }

//    public Sandwich createSandwich(Sandwich sandwich) {
//
//    }
}
