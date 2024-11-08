package com.pluralsight.model.toppings;

import com.pluralsight.model.size.ISizeable;

public abstract class PremiumTopping extends Topping implements ISizeable {
    public PremiumTopping(String toppingName) {
        super(toppingName);
    }
}