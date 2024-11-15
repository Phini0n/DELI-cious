package com.pluralsight.model.menuitem.sandwich;

import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.sandwich.toppings.Topping;

import java.util.ArrayList;

public class SignatureSandwich extends Sandwich {

    public SignatureSandwich(Size size, boolean isToasted, String bread, ArrayList<Topping> toppings) {
        super(size, isToasted, bread, toppings);
    }
}
