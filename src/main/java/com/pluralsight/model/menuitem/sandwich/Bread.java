package com.pluralsight.model.menuitem.sandwich;

public enum Bread {
    WHITE("White"),
    WHEAT("Wheat"),
    RYE("Rye"),
    WRAP("Wrap");

    public final String breadType;
    Bread(String breadType) {
        this.breadType = breadType;
    }
}
