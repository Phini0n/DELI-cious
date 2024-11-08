package com.pluralsight.model.size;

import com.pluralsight.model.sandwich.Sandwich;

import java.math.BigDecimal;
import java.util.HashMap;

public final class SizeHelper {
    private SizeHelper() {}
    public static BigDecimal getSizedPrice(Size size, HashMap<Size, BigDecimal> sizePrices) {
        return sizePrices.get(size);
    }
}
