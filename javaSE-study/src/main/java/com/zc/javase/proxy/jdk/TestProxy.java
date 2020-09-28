package com.zc.javase.proxy.jdk;

/**
 * @author zhao.cheng
 * @date 2020/9/8 15:34
 */
public class TestProxy {

    public static void main(String[] args) {
        DebugProxy debugProxy = new DebugProxy(new SmsServiceImpl());
        SmsService smsService = debugProxy.getProxy(SmsService.class);
        smsService.send("java");
    }
}
