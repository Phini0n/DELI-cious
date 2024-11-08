package com.pluralsight.model.menuitem.sandwich.topping;

import com.pluralsight.model.size.Size;

public abstract class PremiumTopping extends Topping {
    protected Size size;

    public PremiumTopping(String toppingName, Size size) {
        super(toppingName);
        this.size = size;
    }
}