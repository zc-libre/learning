package com.zc.pattern.observer.event;

import com.google.common.eventbus.Subscribe;
import com.zc.pattern.observer.biz.NotificationService;
import com.zc.pattern.observer.biz.ReObserver;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:55
 */
public class RegNotificationObserver  {

    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "Notification");
    }
}
