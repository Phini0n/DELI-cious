package com.pluralsight.model.toppings;

public abstract class Topping {
    private String toppingName;

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    @Override
    public String toString() {
        return this.toppingName;
    };
}
