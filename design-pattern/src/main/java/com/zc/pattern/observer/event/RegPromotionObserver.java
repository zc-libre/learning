package com.zc.pattern.observer.event;

import com.google.common.eventbus.Subscribe;
import com.zc.pattern.observer.biz.PromotionService;
import com.zc.pattern.observer.biz.ReObserver;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:52
 */
public class RegPromotionObserver  {

    private PromotionService promotionService;

    @Subscribe
    public  void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
