package com.zc.leetcode.thread;

/**
 * @author zhao.cheng
 * @date 2020/10/10 11:33
 */
public class PrintTest {
    public static void main(String[] args)  {
     PrintByOrder print = new PrintByOrder();

     new Thread(print::second).start();
     new Thread(print::third).start();
     new Thread(print::first).start();
    }
}
