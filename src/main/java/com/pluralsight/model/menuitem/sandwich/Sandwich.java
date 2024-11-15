package com.pluralsight.model.menuitem.sandwich;

import com.pluralsight.model.Size;
import com.pluralsight.model.menuitem.IPriceable;
import com.pluralsight.model.menuitem.sandwich.toppings.Topping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Sandwich implements IPriceable {
    private Size size;
    private boolean isToasted;
    private String bread;
    private List<Topping> toppings = new ArrayList<>();

    private static final EnumMap<Size, BigDecimal> SIZE_PRICES = new EnumMap<>(Map.of(
            Size.SMALL, new BigDecimal("5.50"),
            Size.MEDIUM, new BigDecimal("7.00"),
            Size.LARGE, new BigDecimal("8.50")
    ));

    public Sandwich(Size size, boolean isToasted, String bread, ArrayList<Topping> toppings) {
        this.size = size;
        this.isToasted = isToasted;
        this.bread = bread;
        this.toppings = toppings;
    }

    // TODO: Include costs of all things inside sandwich.
    public BigDecimal getPrice() {
        if (toppings.isEmpty()) {
            return Sandwich.SIZE_PRICES.get(size);
        } else {
            BigDecimal toppingPrice = Sandwich.SIZE_PRICES.get(size);
            for (Topping topping : toppings) {
                toppingPrice = toppingPrice.add(topping.getPrice());
                return toppingPrice;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        // Sandwich
        sb.append("Sandwich: ").append(size.sandwichSizeName);
        sb.append(isToasted ? " Toasted " : " ");
        sb.append(bread).append("bread | ");

        // Toppings
        if (!toppings.isEmpty()) {
            sb.append("Toppings: ");
            for (int i = 0; i < toppings.size(); i++) {
                sb.append(toppings.get(i).getToppingName());
                if (i != toppings.size() - 1) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append("No toppings");
        }

        // Price
        sb.append(" - Price: $").append(getPrice().setScale(2, BigDecimal.ROUND_HALF_UP));

        return sb.toString();
    }
}
