package com.spang.pattern.singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author zhao.cheng
 * @date 2020/8/20 13:09
 */
public class IdGenerator {

    private final AtomicLong id = new AtomicLong(0);
    private volatile static IdGenerator instance;

    private IdGenerator(){};

    public static IdGenerator getInstance() {
       if (instance == null) {
           synchronized (IdGenerator.class) {
               if (instance == null) {
                   instance = new IdGenerator();
               }
           }
       }
       return instance;
    }

    public Long getId() {
        return id.incrementAndGet();
    }
}
