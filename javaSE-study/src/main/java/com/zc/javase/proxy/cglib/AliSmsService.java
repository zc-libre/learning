package com.zc.javase.proxy.cglib;

/**
 * @author zhao.cheng
 * @date 2020/9/8 15:58
 */
public class AliSmsService {

    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}
