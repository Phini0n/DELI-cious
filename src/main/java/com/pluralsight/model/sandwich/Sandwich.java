package com.pluralsight.model.sandwich;

import com.pluralsight.model.size.ISizeable;
import com.pluralsight.model.size.Size;
import com.pluralsight.model.topping.Topping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sandwich implements ISizeable {
    private Size itemSize;
    private boolean isToasted;
    private Bread bread;
    private List<Topping> toppings = new ArrayList<>();
    private static final HashMap<Size, BigDecimal> SIZE_PRICES = new HashMap<Size, BigDecimal>() {{
        put(Size.SMALL, new BigDecimal(1.00)); // 4"
        put(Size.MEDIUM, new BigDecimal(2.00)); // 8"
        put(Size.LARGE, new BigDecimal(3.00)); // 12"
    }};

    @Override
    public BigDecimal getPrice(Size size) {
        return Sandwich.SIZE_PRICES.get(size);
    }

    @Override
    public void setSize(Size newSize) {
        this.itemSize = newSize;
    }
}
