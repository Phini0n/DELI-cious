package com.pluralsight.model.menuitem.sandwich.topping;

import com.pluralsight.model.Size;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cheese extends PremiumTopping {
    private static final HashMap<Size, BigDecimal> SIZE_PRICES = new HashMap<Size, BigDecimal>() {{
        put(Size.SMALL, new BigDecimal(".75")); // 4"
        put(Size.MEDIUM, new BigDecimal("1.50")); // 8"
        put(Size.LARGE, new BigDecimal("2.25")); // 12"
    }};

    public Cheese(String toppingName, Size size) {
        super(toppingName, size);
        this.price = SIZE_PRICES.get(size);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
