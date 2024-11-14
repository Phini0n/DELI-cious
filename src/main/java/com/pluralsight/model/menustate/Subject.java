package com.pluralsight.model.menustate;

public interface Subject {
    void addObserver(Observer observer);
    void notifyObservers();
}
