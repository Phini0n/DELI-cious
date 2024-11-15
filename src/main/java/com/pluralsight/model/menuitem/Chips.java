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
        StringBuilder sb = new StringBuilder();

        sb.append("Chips: ");
        sb.append(type).append(" - ");

        sb.append("Price: $").append(getPrice().setScale(2, BigDecimal.ROUND_HALF_UP));

        return sb.toString();
    }

    public BigDecimal getPrice() {
        return Chips.PRICE;
    }
}
