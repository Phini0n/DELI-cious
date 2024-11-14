package com.pluralsight.model.menuitem.sandwich.toppings;

import com.pluralsight.model.Size;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class Meat extends PremiumTopping {
    private static final EnumMap<Size, BigDecimal> SIZE_PRICES = new EnumMap<>(Map.of(
            Size.SMALL, new BigDecimal("1.00"),
            Size.MEDIUM, new BigDecimal("2.00"),
            Size.LARGE, new BigDecimal("3.00")
    ));

    public Meat(String toppingName, Size size) {
        super(toppingName, size);
        this.price = SIZE_PRICES.get(size);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
