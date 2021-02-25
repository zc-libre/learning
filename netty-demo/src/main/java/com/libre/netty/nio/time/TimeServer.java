package com.libre.netty.nio.time;

/**
 * @author zhao.cheng
 * @date 2021/2/24 10:30
 */
public class TimeServer {
    public static void main(String[] args) {

        new Thread(new MultiplexerTimeServer(8080)).start();

    }
}
