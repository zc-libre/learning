package com.zc.pattern.observer.biz;

/**
 * @author zhao.cheng
 * @date 2021/4/22 9:52
 */
public class RegPromotionObserver implements ReObserver {

    private PromotionService promotionService;

    @Override
    public void handleRegSuccess(long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
