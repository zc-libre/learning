package com.zc.pattern.observer.biz;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:56
 */
public interface NotificationService {

    void sendInboxMessage(long userId, String message);
}
