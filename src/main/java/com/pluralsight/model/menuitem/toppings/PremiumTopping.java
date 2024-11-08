package com.pluralsight.model.menuitem.toppings;

import com.pluralsight.model.size.ISizeable;
import com.pluralsight.model.size.Size;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class PremiumTopping extends Topping implements ISizeable {
    public PremiumTopping(String toppingName) {
        super(toppingName);
    }
}