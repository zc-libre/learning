package com.zc.pattern.basis.chapter_10.demo1;

import com.zc.pattern.basis.chapter_10.demo1.ability.EggLayAbility;
import com.zc.pattern.basis.chapter_10.demo1.ability.TweetAbility;
import com.zc.pattern.basis.chapter_10.demo1.able.EggLayable;
import com.zc.pattern.basis.chapter_10.demo1.able.Tweetable;

/**
 * @author zhao.cheng
 * @date 2020/8/11 13:07
 */
public class Ostrich implements Tweetable, EggLayable {

   private final TweetAbility tweetAbility =  new TweetAbility();
   private final EggLayAbility eggLayAbility = new EggLayAbility();

    public void layEgg() {
        eggLayAbility.layEgg();
    }

    public void tweet() {
       tweetAbility.tweet();
    }

}
