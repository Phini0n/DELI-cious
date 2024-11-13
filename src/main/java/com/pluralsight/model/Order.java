package com.pluralsight.model;

import com.pluralsight.model.menuitem.Chips;
import com.pluralsight.model.menuitem.Drink;
import com.pluralsight.model.menuitem.sandwich.Sandwich;

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
        return "Order{" +
                "dateTime=" + dateTime +
                ", sandwiches=" + sandwiches +
                ", drinks=" + drinks +
                ", chips=" + chips +
                '}';
    }
}
