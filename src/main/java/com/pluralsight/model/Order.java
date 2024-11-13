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

    public Order(LocalDateTime dateTime, List<Sandwich> sandwiches, List<Drink> drinks, List<Chips> chips) {
        this.dateTime = dateTime;
        this.sandwiches = sandwiches;
        this.drinks = drinks;
        this.chips = chips;
    }

    public Order() {

    }
}
