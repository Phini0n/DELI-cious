package com.pluralsight.model.menuitem.sandwich.topping;

import java.math.BigDecimal;

public class Topping {
    private String toppingName;

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
