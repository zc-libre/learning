package com.spang.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhao.cheng
 * @date 2020/8/20 13:18
 */
public class IdGeneratorInner {

    private final AtomicLong id = new AtomicLong(0);
    private IdGeneratorInner(){};

    private static class SingletonHolder{
        private static final IdGeneratorInner instance = new IdGeneratorInner();
    }

    public static IdGeneratorInner getInstance() {
        return SingletonHolder.instance;
    }

    public long getId() {
        return id.incrementAndGet();
    }

}
