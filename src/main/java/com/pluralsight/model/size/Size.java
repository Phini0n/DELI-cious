package com.pluralsight.model.size;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE ("Large");

    public final String sizeName;

    Size(String sizeName) {
        this.sizeName = sizeName;
    }
}
