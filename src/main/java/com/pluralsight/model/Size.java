package com.pluralsight.model;

public enum Size {
    SMALL("Small", "4\""),
    MEDIUM("Medium", "8\""),
    LARGE ("Large", "12\"");

    public final String sizeName;
    public final String sandwichSizeName;

    Size(String sizeName, String sandwichSizeName) {
        this.sizeName = sizeName;
        this.sandwichSizeName = sandwichSizeName;
    }

    public String getSize() {
        return this.sizeName;
    }

    public static Size standardSizeFromString(String text) {
        for (Size s : Size.values()) {
            if (s.sizeName.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return null;
    }

    public static Size sandwichSizeFromString(String text) {
        for (Size s : Size.values()) {
            if (s.sandwichSizeName.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return null;
    }
}
