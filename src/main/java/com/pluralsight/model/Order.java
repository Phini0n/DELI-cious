package com.pluralsight.model;

import com.pluralsight.model.menuitem.Chips;
import com.pluralsight.model.menuitem.Drink;
import com.pluralsight.model.menuitem.sandwich.Sandwich;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private LocalDateTime dateTime;
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order(LocalDateTime dateTime, List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.dateTime = dateTime;
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }
}
