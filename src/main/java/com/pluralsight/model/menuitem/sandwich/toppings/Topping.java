package com.pluralsight.model.menuitem.sandwich.toppings;

import java.math.BigDecimal;

public class Topping {
    private final String toppingName;

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    @Override
    public String toString() {
        return this.toppingName;
    };

    public BigDecimal getPrice() {
        return BigDecimal.ZERO;
    }
}
