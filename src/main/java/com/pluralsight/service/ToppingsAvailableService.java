package com.pluralsight.service;

import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.sandwich.toppings.*;

import java.util.ArrayList;
import java.util.List;

public class ToppingsAvailableService {
    private Size defaultSize = Size.SMALL;

    private List<Meat> meatToppingsAvailable = new ArrayList<Meat>() {{
        add (new Meat("Steak", defaultSize));
        add (new Meat("Ham", defaultSize));
        add (new Meat("Salami", defaultSize));
        add (new Meat("Roast Beef", defaultSize));
        add (new Meat("Chicken", defaultSize));
        add (new Meat("Bacon", defaultSize));
    }};

    private List<Cheese> cheeseToppingsAvailable = new ArrayList<Cheese>() {{
        add (new Cheese("American", defaultSize));
        add (new Cheese("Provolone", defaultSize));
        add (new Cheese("Cheddar", defaultSize));
        add (new Cheese("Swiss", defaultSize));
    }};

    private List<Topping> regularToppingsAvailable = new ArrayList<Topping>() {{
        add (new Topping("Lettuce"));
        add (new Topping("Peppers"));
        add (new Topping("Onions"));
        add (new Topping("Tomatoes"));
        add (new Topping("Jalapenos"));
        add (new Topping("Cucumbers"));
        add (new Topping("Pickles"));
        add (new Topping("Guacamole"));
        add (new Topping("Mushrooms"));
    }};

    private List<Sauce> saucesAvailable = new ArrayList<Sauce>() {{
        add (new Sauce("Mayo"));
        add (new Sauce("Mustard"));
        add (new Sauce("Ketchup"));
        add (new Sauce("Ranch"));
        add (new Sauce("Thousand Islands"));
        add (new Sauce("Vinaigrette"));
    }};

    public List<Meat> getMeatToppingsAvailable() {
        return meatToppingsAvailable;
    }

    public List<Cheese> getCheeseToppingsAvailable() {
        return cheeseToppingsAvailable;
    }

    public List<Topping> getRegularToppingsAvailable() {
        return regularToppingsAvailable;
    }

    public List<Sauce> getSaucesAvailable() {
        return saucesAvailable;
    }

    public <T extends Topping> String toppingsToNumberedList(List<T> toppings) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        for (int i = 0; i < toppings.size(); i++) {
            sb.append(i+1).append(") ").append(toppings.get(i).getToppingName());
            if (i != toppings.size()) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public Meat getMeatTopping(String searchedMeat) {
        ArrayList<Meat> meats = (ArrayList<Meat>) meatToppingsAvailable;
        for (Meat meat : meats) {
            if (meat.getToppingName().equals(searchedMeat)) {
                return meat;
            }
        }
        return null;
    }

    public Cheese getCheeseTopping(String searchedCheese) {
        ArrayList<Cheese> cheeses = (ArrayList<Cheese>) cheeseToppingsAvailable;
        for (Cheese cheese : cheeses) {
            if (cheese.getToppingName().equals(searchedCheese)) {
                return cheese;
            }
        }
        return null;
    }

    public Topping getRegularTopping(String searchedTopping) {
        ArrayList<Topping> toppings = (ArrayList<Topping>) regularToppingsAvailable;
        for (Topping topping : toppings) {
            if (topping.getToppingName().equals(searchedTopping)) {
                return topping;
            }
        }
        return null;
    }

    public Sauce getSauce(String searchedSauce) {
        ArrayList<Sauce> sauces = (ArrayList<Sauce>) saucesAvailable;
        for (Sauce sauce : sauces) {
            if (sauce.getToppingName().equals(searchedSauce)) {
                return sauce;
            }
        }
        return null;
    }
}
