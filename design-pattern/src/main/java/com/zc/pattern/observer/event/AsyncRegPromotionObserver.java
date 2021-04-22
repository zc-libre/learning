package com.zc.pattern.observer.event;

import com.zc.pattern.observer.biz.PromotionService;
import com.zc.pattern.observer.biz.ReObserver;

/**
 * @author zhao.cheng
 * @date 2021/4/22 10:04
 */
public class AsyncRegPromotionObserver implements ReObserver {

    private PromotionService promotionService;

    @Override
    public void handleRegSuccess(long userId) {
        new Thread(() -> promotionService.issueNewUserExperienceCash(userId)).start();
    }
}
