package com.pluralsight.service;

import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.sandwich.toppings.Cheese;
import com.pluralsight.model.menuitem.sandwich.toppings.Meat;
import com.pluralsight.model.menuitem.sandwich.toppings.Sauce;
import com.pluralsight.model.menuitem.sandwich.toppings.Topping;

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
}
