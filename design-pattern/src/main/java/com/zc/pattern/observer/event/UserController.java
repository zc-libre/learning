package com.zc.pattern.observer.event;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.zc.pattern.observer.template.Observer;

import java.util.List;
import java.util.concurrent.Executors;

/**
 * @author zhao.cheng
 * @date 2021/4/22 10:33
 */
@SuppressWarnings("UnstableApiUsage")
public class UserController {

    private EventBus eventBus;
    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public UserController() {
        eventBus = new AsyncEventBus(Executors.newFixedThreadPool(DEFAULT_EVENTBUS_THREAD_POOL_SIZE));
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }
    public Long register(Long userId) {
        eventBus.post(userId);
        return userId;
    }
}
