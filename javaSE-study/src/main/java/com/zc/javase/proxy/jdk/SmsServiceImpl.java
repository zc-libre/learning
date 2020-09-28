package com.zc.javase.proxy.jdk;

/**
 * @author zhao.cheng
 * @date 2020/9/8 15:26
 */
public class SmsServiceImpl implements SmsService{

    public String send(String message) {
        System.out.println("send message: " + message);
        return message;
    }
}
