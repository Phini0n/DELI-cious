package com.pluralsight.model.menuitem.sandwich;

import com.pluralsight.model.Size;

public enum Bread {
    WHITE("White"),
    WHEAT("Wheat"),
    RYE("Rye"),
    WRAP("Wrap");

    public final String breadType;
    Bread(String breadType) {
        this.breadType = breadType;
    }

    public static Bread fromString(String text) {
        for (Bread b : Bread.values()) {
            if (b.breadType.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
