package com.pluralsight.model.menuitem.sandwich.toppings;

import com.pluralsight.model.Size;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class Cheese extends PremiumTopping {
    private static final EnumMap<Size, BigDecimal> SIZE_PRICES = new EnumMap<>(Map.of(
            Size.SMALL, new BigDecimal(".75"),
            Size.MEDIUM, new BigDecimal("1.50"),
            Size.LARGE, new BigDecimal("2.25")
    ));

    public Cheese(String toppingName, Size size) {
        super(toppingName, size);
        this.price = SIZE_PRICES.get(size);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
