package com.pluralsight.model;

import com.pluralsight.model.menuitem.Chips;
import com.pluralsight.model.menuitem.Drink;
import com.pluralsight.model.menuitem.sandwich.Sandwich;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private LocalDateTime dateTime;
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public Order() {}

    public void setTime() {
        dateTime = LocalDateTime.now();
    }

    public LocalDateTime getTime() {
        return dateTime;
    }

    public void addSandwich(Sandwich sandwich) {
        this.sandwiches.add(sandwich);
    }

    public void addChips(Chips chips) {
        this.chips.add(chips);
    }

    public void addDrink(Drink drink) {
        this.drinks.add(drink);
    }

    public void orderClear() {
        this.dateTime = null;
        this.sandwiches.clear();
        this.drinks.clear();
        this.chips.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (dateTime != null) {
            sb.append("Order Date/Time: ").append(dateTime).append("\n");
        }

        if (!sandwiches.isEmpty()) {
            sb.append("Sandwiches:\n");
            for (Sandwich sandwich : sandwiches) {
                sb.append("  ").append(sandwich.toString()).append("\n");
            }
        }

        if (!drinks.isEmpty()) {
            sb.append("Drinks:\n");
            for (Drink drink : drinks) {
                sb.append("  ").append(drink.toString()).append("\n");
            }
        }

        if (!chips.isEmpty()) {
            sb.append("Chips:\n");
            for (Chips chip : chips) {
                sb.append("  ").append(chip.toString()).append("\n");
            }
        }

        // Calculations
        BigDecimal totalPrice = new BigDecimal("0.00");
        for (Sandwich sandwich : sandwiches) {
            totalPrice = totalPrice.add(sandwich.getPrice());
        }
        for (Drink drink : drinks) {
            totalPrice = totalPrice.add(drink.getPrice());
        }
        for (Chips chip : chips) {
            totalPrice = totalPrice.add(chip.getPrice());
        }

        sb.append("Total Price: $").append(totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP)).append("\n");

        return sb.toString();
    }
}
