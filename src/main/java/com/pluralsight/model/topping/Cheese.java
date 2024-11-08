package com.pluralsight.model.topping;

import com.pluralsight.model.size.Size;
import com.pluralsight.model.size.SizeHelper;

import java.math.BigDecimal;
import java.util.HashMap;

public class Cheese extends PremiumTopping {
    private static final HashMap<Size, BigDecimal> SIZE_PRICES = new HashMap<Size, BigDecimal>() {{
        put(Size.SMALL, new BigDecimal(.75)); // 4"
        put(Size.MEDIUM, new BigDecimal(1.50)); // 8"
        put(Size.LARGE, new BigDecimal(2.25)); // 12"
    }};

    public Cheese(String toppingName, Size size) {
        super(toppingName, size);
    }

    public BigDecimal getPrice() {
        return SizeHelper.getSizedPrice(this.size, SIZE_PRICES);
    }
}
