package com.zc.pattern.observer.biz;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:58
 */
public class UserController {

    private List<ReObserver> reObservers = new ArrayList<>();

    public void setReObservers(List<ReObserver> reObservers) {
        this.reObservers = reObservers;
    }

    public void register(String telephone, String password) {
        long userId = 1;

        for (ReObserver reObserver : reObservers) {
            reObserver.handleRegSuccess(userId);
        }
    }
}
