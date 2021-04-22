package com.zc.pattern.observer.template;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:28
 */
public class ConcreteSubject implements Subject {

    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
       observers.remove(observer);
    }

    @Override
    public void notifyObservers(Message message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
