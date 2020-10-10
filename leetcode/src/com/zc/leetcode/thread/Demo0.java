package com.zc.leetcode.thread;

/**
 * @author zhao.cheng
 * @date 2020/10/10 11:48
 */
public class Demo0 {

    int balance = 500;

    public int withDraw(int amount) {
        if (amount < balance) {
            balance -= amount;
        }
        return balance;
    }
}
