package com.zc.pattern.observer.template;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:33
 */
public class Demo {
    public static void main(String[] args) {
        Subject subject = new ConcreteSubject();
        subject.registerObserver(new ConcreteObserverOne());
        subject.registerObserver(new ConcreteObserverTwo());
        subject.notifyObservers(new Message());
    }
}
