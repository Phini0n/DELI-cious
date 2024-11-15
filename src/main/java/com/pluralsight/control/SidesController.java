package com.pluralsight.control;

import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.Chips;
import com.pluralsight.model.menuitem.Drink;
import com.pluralsight.view.Display;

public class SidesController {

    private final Display display = new Display();

    public Drink processDrinkRequest() {
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
                    Size size = Size.standardSizeFromString(entry[0]);

                    // Checking if size is correct
                    if (size != null) {
                        return new Drink(size, entry[1]);
                    } else {
                        display.showMessageLine("Our sizes are Small, Medium, and Large. " +
                                "Please try again, or enter 0 to exit.");
                    }

                    // Checking if user wants to exit
                } else if (entry[0].equals("0")) {
                    display.showMessageLine("Returning to Order menu.");
                    return null;

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

    public Chips processChipsRequest() {
        display.showMessage("""
                Please enter any flavor of chips you'd like.
                Enter 0 to stop ordering Chips.
                
                Enter:\s""");

        display.clearBuffer();

        String entry = display.getUserString().trim();
        if (entry.equals("0")) {
            display.showMessageLine("Returning to Order menu.");
            return null;
        } else {
            return new Chips(entry);
        }
    }

}