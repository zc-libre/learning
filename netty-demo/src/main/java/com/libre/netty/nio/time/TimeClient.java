package com.libre.netty.nio.time;

/**
 * @author zhao.cheng
 * @date 2021/2/24 13:40
 */
public class TimeClient {
    public static void main(String[] args) {
       new Thread(new TimeClientHandle("127.0.0.1",8080)).start();
    }
}
