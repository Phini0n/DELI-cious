package com.pluralsight.control;

import com.pluralsight.model.menustate.MenuState;
import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.sandwich.Bread;
import com.pluralsight.model.menuitem.sandwich.Sandwich;
import com.pluralsight.model.menuitem.sandwich.toppings.Topping;
import com.pluralsight.model.menustate.Observer;
import com.pluralsight.service.MenuStateManager;
import com.pluralsight.view.Display;

import java.util.ArrayList;
import java.util.List;

public class SandwichController implements Observer {
    private Display display = new Display();
    private MenuState menuState;
    private MenuStateManager stateManager;

    // Sandwich Variables
    Sandwich finalSandwich;
    private Size sandwichSize;
    private boolean isToasted;
    private boolean isCancelled; // Determines if the initialize process will continue, or not.
    private boolean isSignature; // Determines if this Sandwich is signature, or not.
    private Bread bread;
    private List<Topping> toppings = new ArrayList<Topping>();
    private List<Object> cart = new ArrayList<>();

    public SandwichController (MenuStateManager stateManager) {
        this.stateManager = stateManager;
        stateManager.addObserver(this);
    }

    // Using Custom Sandwich
    public void initializeSandwich() {
        isCancelled = false;
        processSizeRequest();
        processIsToastedRequest();
        processBreadRequest();
        if (isCancelled) {
            display.showMessage("Sandwich process was cancelled. Returning to Order menu.");
        }
    }

    // Using Signature Sandwich
    public void initializeSandwich(Sandwich sandwich) {
        // TODO: Implement this.
    }

    private void handleSandwichScreen() {
        stateManager.setMenuState(MenuState.SANDWICH_SCREEN);
    }

    public void handleToppingsScreen() {
        stateManager.setMenuState(MenuState.TOPPINGS_SCREEN);
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
        StringBuilder allToppings = new StringBuilder();
        for (Topping topping : toppings) {
            allToppings.append(topping).append(" ");
        }

        String toastedStatus = isToasted ? " toasted " : " ";
        String signatureStatus = isSignature ? "Signature:  with" : " ";


        return "Your current sandwich:\n" +
                sandwichSize.sandwichSizeName + signatureStatus +  toastedStatus + bread.breadType +
                " with " + allToppings.toString();
    }

    @Override
    public void update(MenuState menuState) {
        this.menuState = menuState;
    }

//    public Sandwich createSandwich(Sandwich sandwich) {
//
//    }
}
