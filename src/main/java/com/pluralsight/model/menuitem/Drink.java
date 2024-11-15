package com.pluralsight.model.menuitem;

import com.pluralsight.model.Size;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

public class Drink implements IPriceable {
    private final String flavor;
    private final Size itemSize;
    private final BigDecimal price;

    private static final EnumMap<Size, BigDecimal> SIZE_PRICES = new EnumMap<>(Map.of(
            Size.SMALL, new BigDecimal("2.00"),
            Size.MEDIUM, new BigDecimal("2.50"),
            Size.LARGE, new BigDecimal("3.00")
    ));

    public Drink(Size size, String flavor) {
        this.flavor = flavor;
        this.itemSize = size;
        this.price = SIZE_PRICES.get(size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Drink details
        sb.append("Drink: ").append(itemSize).append(" ");
        sb.append(flavor).append(" - ");

        // Price
        sb.append("Price: $").append(getPrice().setScale(2, BigDecimal.ROUND_HALF_UP));

        return sb.toString();
    }

    public BigDecimal getPrice() {
        return price;
    }
}
