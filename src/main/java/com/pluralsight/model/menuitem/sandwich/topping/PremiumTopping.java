package com.pluralsight.model.menuitem.sandwich.topping;

import com.pluralsight.model.size.Size;

import java.math.BigDecimal;

public abstract class PremiumTopping extends Topping {
    protected Size size;
    protected BigDecimal price;

    public PremiumTopping(String toppingName, Size size) {
        super(toppingName);
        this.size = size;
    }
}