package com.pluralsight.model;

import com.pluralsight.model.size.Size;
import com.pluralsight.model.size.SizeHelper;

import java.math.BigDecimal;
import java.util.HashMap;

public class Drinks {
    private String flavor;
    private Size itemSize;

    private static final HashMap<Size, BigDecimal> SIZE_PRICES = new HashMap<Size, BigDecimal>() {{
        put(Size.SMALL, new BigDecimal(2.00)); // 4"
        put(Size.MEDIUM, new BigDecimal(2.50)); // 8"
        put(Size.LARGE, new BigDecimal(3.00)); // 12"
    }};

    public Drinks(String flavor, Size size) {
        this.flavor = flavor;
        this.itemSize = size;
    }

    @Override
    public String toString() {
        return this.flavor;
    }

    public BigDecimal getPrice() {
        return SizeHelper.getSizedPrice(this.itemSize, SIZE_PRICES);
    }
}
