package com.pluralsight.model.topping;

public class Topping {
    private String toppingName;

    public Topping(String toppingName) {
        this.toppingName = toppingName;
    }

    @Override
    public String toString() {
        return this.toppingName;
    };
}
