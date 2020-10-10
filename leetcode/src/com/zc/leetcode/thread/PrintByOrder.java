package com.zc.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhao.cheng
 * @date 2020/10/10 11:24
 */
public class PrintByOrder {

    private final AtomicInteger firstJobDone  = new AtomicInteger(0);
    private final AtomicInteger secondJobDone = new AtomicInteger(0);

    public PrintByOrder() {}

    public void first()  {

        // printFirst.run() outputs "first". Do not change or remove this line.

        System.out.println("first");
        firstJobDone.incrementAndGet();
    }

    public void second()  {
        while (firstJobDone.get() != 1) {
            // waiting for the first job to be done.
        }
        // printSecond.run() outputs "second". Do not change or remove this line.

        System.out.println("second");
        secondJobDone.incrementAndGet();
    }

    public void third()  {
        while (secondJobDone.get() != 1) {
            // waiting for the second job to be done.
        }
        System.out.println("third");
        // printThird.run() outputs "third". Do not change or remove this line.
    }

}
