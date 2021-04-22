package com.zc.pattern.observer.template;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:25
 */
public interface Subject {

     void registerObserver(Observer observer);

     void removeObserver(Observer observer);

     void notifyObservers(Message message);
}
