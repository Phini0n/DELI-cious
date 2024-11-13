package com.pluralsight.model.menuitem.sandwich.topping;

import com.pluralsight.model.Size;

import java.math.BigDecimal;
import java.util.HashMap;

public class Meat extends PremiumTopping {
    private static final HashMap<Size, BigDecimal> SIZE_PRICES = new HashMap<Size, BigDecimal>() {{
        put(Size.SMALL, new BigDecimal("1.00")); // 4"
        put(Size.MEDIUM, new BigDecimal("2.00")); // 8"
        put(Size.LARGE, new BigDecimal("3.00")); // 12"
    }};

    public Meat(String toppingName, Size size) {
        super(toppingName, size);
        this.price = SIZE_PRICES.get(size);
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
