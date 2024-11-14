package com.pluralsight;

import com.pluralsight.control.OrderController;
import com.pluralsight.control.SandwichController;
import com.pluralsight.service.MenuStateManager;

public class Main {
    public static void main(String[] args) {
        MenuStateManager stateManager = new MenuStateManager();
        SandwichController sandwichController = new SandwichController(stateManager);
        OrderController orderController = new OrderController(stateManager, sandwichController);

        orderController.display();

    }
}