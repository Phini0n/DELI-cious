package com.pluralsight;

import com.pluralsight.control.OrderController;
import com.pluralsight.control.SandwichController;
import com.pluralsight.service.MenuStateManager;

public class Main {
    public static void main(String[] args) {
        MenuStateManager stateManager = new MenuStateManager();
        OrderController orderController = new OrderController(stateManager);
        SandwichController sandwichController = new SandwichController(stateManager);
        orderController.display();
    }
}