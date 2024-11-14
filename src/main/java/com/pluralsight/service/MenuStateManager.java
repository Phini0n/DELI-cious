package com.pluralsight.service;

import com.pluralsight.model.menustate.MenuState;
import com.pluralsight.model.menustate.Observer;
import com.pluralsight.model.menustate.Subject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MenuStateManager implements Subject {
    private List<Observer> observerList = new ArrayList<>();
    private MenuState menuState;

    @Override
    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(menuState);
        }
    }

    public void setMenuState(MenuState menuState) {
        this.menuState = menuState;
        notifyObservers();
    }
}
