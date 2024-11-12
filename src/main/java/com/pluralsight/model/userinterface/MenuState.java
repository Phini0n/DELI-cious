package com.pluralsight.model.userinterface;

public enum MenuState {
    HOME_SCREEN("Home Screen", new String[] {"New Order", "Exit"}),
    ORDER_SCREEN("Order Screen", new String[] {"Add Signature Sandwich", "Add New Sandwich",
            "Add Drink", "Add Chips", "Checkout"});

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
            // If we are reaching the last option/index, it becomes zero. Else, add 1.
            int displayIndex = (i == this.getOptions().length - 1) ? 0 : i + 1;
            stringBuilder.append(displayIndex).append(") ").append(this.getOptions()[i]);
            if(!(i == this.getOptions().length)) { stringBuilder.append(System.lineSeparator()); }
        }
        return stringBuilder.toString();
    }
}
