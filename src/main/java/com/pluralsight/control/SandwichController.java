package com.pluralsight.control;

import com.pluralsight.model.MenuState;
import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.Drink;
import com.pluralsight.model.menuitem.sandwich.Bread;
import com.pluralsight.model.menuitem.sandwich.Sandwich;
import com.pluralsight.model.menuitem.sandwich.toppings.Topping;
import com.pluralsight.view.Display;

import java.util.ArrayList;
import java.util.List;

public class SandwichController {
    private Display display;
    private MenuState menuState;

    // Sandwich Variables
    Sandwich sandwich;
    private Size sandwichSize;
    private boolean isToasted;
    private Bread bread;
    private List<Topping> toppings = new ArrayList<Topping>();

    private void init() {
        display = new Display();
    }

    public void display() {
        init();

        handleDisplay();
    }

    private void handleDisplay() {

    }

    public Sandwich createSandwich() {
        // Bread
        display.showMessageLine("""
                Enter your bread (White, Wheat, Rye, Wrap):
                
                Enter:\s
                """);
        try {
            Bread.fromString(display.getUserString());
        } catch (Exception e) {
            display.showMessageLine("\nError " + e + " occurred with your input. Returning to order menu.");
            return null;
        }

        // Size
        display.showMessageLine("""
                Enter your size (Small, Medium, Large):
                
                Enter:\s
                """);
        try {
            Size.fromString(display.getUserString());
        } catch (Exception e) {
            display.showMessageLine("\nError "  + e + " occurred with your input. Returning to order menu.");
        }

        // isToasted
        display.showMessage("Would you like your bread toasted? (Y/N)");
        if (display.getUserString().equalsIgnoreCase("Y")) {
            isToasted = true;
        } else if (display.getUserString().equalsIgnoreCase("N")) {
            isToasted = false;
        } else {
            display.showMessageLine("Invalid input, returning to order menu.");
            return null;
        }

        // Toppings
        display.showMessageLine("""
                Select your toppings:
                1) Meat
                2) Cheese
                3) Other toppings
                4) Sauces
                
                Enter:\s
                """);

    }

//    public Sandwich createSandwich(Sandwich sandwich) {
//
//    }
}
