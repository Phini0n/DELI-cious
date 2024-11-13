package com.pluralsight.model.menuitem.sandwich;

import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.sandwich.toppings.Topping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sandwich {
    private Size size;
    private boolean isToasted;
    private Bread bread;
    private List<Topping> toppings = new ArrayList<>();

    private static final HashMap<Size, BigDecimal> SIZE_PRICES = new HashMap<Size, BigDecimal>() {{
        put(Size.SMALL, new BigDecimal("5.50")); // 4"
        put(Size.MEDIUM, new BigDecimal("7.00")); // 8"
        put(Size.LARGE, new BigDecimal("8.50")); // 12"
    }};

    public Sandwich(Size size, boolean isToasted, Bread bread, ArrayList<Topping> toppings) {
        this.size = size;
        this.isToasted = isToasted;
        this.bread = bread;
        this.toppings = toppings;
    }

    // TODO: Include costs of all things inside sandwich.
    public BigDecimal getPrice() {
        return Sandwich.SIZE_PRICES.get(size);
    }
}
