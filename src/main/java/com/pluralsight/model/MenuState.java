package com.pluralsight.model;

public enum MenuState {
    HOME_SCREEN("Home Screen", new String[] {"New Order", "Exit"}),
    ORDER_SCREEN("Order Screen", new String[] {"Add Signature Sandwich", "Add Custom Sandwich",
            "Add Drink", "Add Chips", "Checkout", "Cancel Order"});

    private final String title;
    private final String[] options;

    MenuState(String title, String[] options) {
        this.title = title;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public String[] getOptions() {
        return options;
    }

    public String getOptionsList() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.getOptions().length; i++) {
            // If we are reaching the last option/index, it becomes zero. Else, add 1 to display it.
            int displayIndex = (i == this.getOptions().length - 1) ? 0 : i + 1;
            stringBuilder.append(displayIndex).append(") ").append(this.getOptions()[i]);
            // If we are not at the end, append a break
            if(!(i == this.getOptions().length)) { stringBuilder.append("\n"); }
        }
        return stringBuilder.toString();
    }
}
