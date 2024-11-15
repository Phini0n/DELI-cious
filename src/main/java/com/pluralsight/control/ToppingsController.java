package com.pluralsight.control;

import com.pluralsight.model.menuitem.sandwich.toppings.Cheese;
import com.pluralsight.model.menuitem.sandwich.toppings.Meat;
import com.pluralsight.model.menuitem.sandwich.toppings.Sauce;
import com.pluralsight.model.menuitem.sandwich.toppings.Topping;
import com.pluralsight.model.menustate.MenuState;
import com.pluralsight.service.ToppingsAvailableService;
import com.pluralsight.view.Display;

import java.util.List;

public class ToppingsController {
    ToppingsAvailableService toppingsAvailableService;
    MenuState menuState;
    Display display = new Display();
    private ToppingsController toppingsController;
    private Topping topping;

    public ToppingsController(MenuState menuState) {
        toppingsAvailableService = new ToppingsAvailableService();
    }

    public Topping handleToppingsScreen(int choice) {
        switch (choice) {
            case 1: // Meat
                List<Meat> meats = toppingsAvailableService.getMeatToppingsAvailable();
                display.showMessage(toppingsAvailableService.toppingsToNumberedList(meats));
                display.showMessage("0) Back\n\nEnter: ");

                int input = display.getUserInt();
                switch (input) {
                    case 1 -> { return toppingsAvailableService.getMeatTopping("Steak"); }
                    case 2 -> { return toppingsAvailableService.getMeatTopping("Ham"); }
                    case 3 -> { return toppingsAvailableService.getMeatTopping("Salami"); }
                    case 4 -> { return toppingsAvailableService.getMeatTopping("Roast Beef"); }
                    case 5 -> { return toppingsAvailableService.getMeatTopping("Chicken"); }
                    case 6 -> { return toppingsAvailableService.getMeatTopping("Bacon"); }
                    case 0 -> {
                        display.showMessageLine("\nReturning to Sandwich Menu\n");
                        return null;
                    }
                }

                break;
            case 2: // Cheese
                List<Cheese> cheeses = toppingsAvailableService.getCheeseToppingsAvailable();
                display.showMessage(toppingsAvailableService.toppingsToNumberedList(cheeses));
                display.showMessage("0) Back\nEnter: \n");
                break;
            case 3: // Other Toppings
                List<Topping> toppings = toppingsAvailableService.getRegularToppingsAvailable();
                display.showMessage(toppingsAvailableService.toppingsToNumberedList(toppings));
                display.showMessage("0) Back\nEnter: \n");
                break;
            case 4: // Sauces
                List<Sauce> sauces = toppingsAvailableService.getSaucesAvailable();
                display.showMessage(toppingsAvailableService.toppingsToNumberedList(sauces));
                display.showMessage("0) Back\nEnter: \n");
                break;
            case 0: // Back
                display.showMessage("Thank you! Returning to sandwich menu. . .");
                return null;
            default:
                display.showMessageLine("\nInvalid entry, returning to sandwich screen..");
        }
        return null;
    }
}
