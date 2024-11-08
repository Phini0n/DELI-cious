package com.pluralsight.model.toppings;

import com.pluralsight.model.size.Size;

import java.math.BigDecimal;
import java.util.HashMap;

public class Meat extends PremiumTopping{
    private Size itemSize;
    private static HashMap<Size, BigDecimal> sizePrices = new HashMap<Size, BigDecimal>() {{
        put(Size.SMALL, new BigDecimal(1.00)); // 4"
        put(Size.MEDIUM, new BigDecimal(2.00)); // 8"
        put(Size.LARGE, new BigDecimal(3.00)); // 12"
    }};

    public Meat(String toppingName, Size size) {
        super(toppingName);
        this.itemSize = size;
    }

    public BigDecimal getPrice(Size size, HashMap<Size, BigDecimal> sizePrices) {
        return Meat.sizePrices.get(size);
    }
}
