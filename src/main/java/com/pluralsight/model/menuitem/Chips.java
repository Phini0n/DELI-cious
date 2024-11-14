package com.pluralsight.model.menuitem;

import java.math.BigDecimal;

public class Chips implements IPriceable {
    private String type;
    private static final BigDecimal PRICE = new BigDecimal(1.50);

    public Chips(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }

    public BigDecimal getPrice() {
        return Chips.PRICE;
    }
}
