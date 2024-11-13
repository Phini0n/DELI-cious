package com.pluralsight.model.size;

public enum Size {
    SMALL("Small"),
    MEDIUM("Medium"),
    LARGE ("Large");

    public final String sizeName;

    Size(String sizeName) {
        this.sizeName = sizeName;
    }

    public String getSize() {
        return this.sizeName;
    }

    public static Size fromString(String text) {
        for (Size s : Size.values()) {
            if (s.sizeName.equalsIgnoreCase(text)) {
                return s;
            }
        }
        return null;
    }
}
