package com.pluralsight;

import com.pluralsight.control.OrderController;
import com.pluralsight.control.SandwichController;
import com.pluralsight.control.SidesController;
import com.pluralsight.service.MenuStateManager;

public class Main {
    public static void main(String[] args) {
        MenuStateManager stateManager = new MenuStateManager();
        SandwichController sandwichController = new SandwichController(stateManager);
        SidesController sidesController = new SidesController();
        OrderController orderController = new OrderController(stateManager, sandwichController, sidesController);

        orderController.display();

    }
}