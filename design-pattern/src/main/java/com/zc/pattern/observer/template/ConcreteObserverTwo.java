package com.zc.pattern.observer.template;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:32
 */
public class ConcreteObserverTwo implements Observer {

    @Override
    public void update(Message message) {
        System.out.println("two update......");
    }
}
