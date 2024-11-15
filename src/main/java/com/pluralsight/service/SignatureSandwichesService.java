package com.pluralsight.service;

import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.sandwich.SignatureSandwich;
import com.pluralsight.model.menuitem.sandwich.toppings.Topping;

import java.util.ArrayList;

public class SignatureSandwichesService {
    private ToppingsAvailableService toppingsAvailableService = new ToppingsAvailableService();
    private ArrayList<Topping> bltToppings = new ArrayList<Topping>() {{
        bltToppings.add(toppingsAvailableService.getCheeseTopping("Cheddar"));
        bltToppings.add(toppingsAvailableService.getMeatTopping("Bacon"));
        bltToppings.add(toppingsAvailableService.getRegularTopping("Lettuce"));
        bltToppings.add(toppingsAvailableService.getRegularTopping("Tomatoes"));
        bltToppings.add(toppingsAvailableService.getSauce("Ranch"));
    }};



    private SignatureSandwich bltSandwich = new SignatureSandwich(Size.MEDIUM, true, "white", bltToppings);

    public SignatureSandwich getBltSandwich() {
        return bltSandwich;
    }
}
