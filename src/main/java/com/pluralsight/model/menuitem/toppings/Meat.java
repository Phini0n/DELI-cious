package com.pluralsight.model.menuitem.toppings;

import com.pluralsight.model.size.Size;

import java.math.BigDecimal;
import java.util.HashMap;

public class Meat extends PremiumTopping{
    Size itemSize;
    private static HashMap<Size, BigDecimal> sizePrices = new HashMap<Size, BigDecimal>() {{
        put(Size.SMALL, new BigDecimal(20));
        put(Size.MEDIUM, new BigDecimal(20));
        put(Size.LARGE, new BigDecimal(20));
    }};

    public Meat(String toppingName) {
        super(toppingName);
    }

    public BigDecimal getPrice(Size size, HashMap<Size, BigDecimal> sizePrices) {
        return Meat.sizePrices.get(size);
    }
}
