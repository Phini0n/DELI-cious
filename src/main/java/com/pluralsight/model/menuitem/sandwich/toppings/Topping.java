package com.pluralsight.model.menuitem.sandwich.toppings;

import com.pluralsight.model.menuitem.IPriceable;

import java.math.BigDecimal;

public class Topping implements IPriceable {
    private final String toppingName ;

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    public String getToppingName() {
        return toppingName;
    }

    public BigDecimal getPrice() {
        return BigDecimal.ZERO;
    }
}
