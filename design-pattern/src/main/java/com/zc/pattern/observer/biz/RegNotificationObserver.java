package com.zc.pattern.observer.biz;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:55
 */
public class RegNotificationObserver implements ReObserver {

    private NotificationService notificationService;

    @Override
    public void handleRegSuccess(long userId) {
        notificationService.sendInboxMessage(userId, "Notification");
    }
}
