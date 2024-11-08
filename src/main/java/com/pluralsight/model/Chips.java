package com.pluralsight.model;

import java.math.BigDecimal;

public class Chips {
    private String type;
    private static final BigDecimal PRICE = new BigDecimal(1.50);

    @Override
    public String toString() {
        return type;
    }

    public BigDecimal getPrice() {
        return Chips.PRICE;
    }
}
