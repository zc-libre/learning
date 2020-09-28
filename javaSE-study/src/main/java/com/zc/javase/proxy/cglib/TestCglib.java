package com.zc.javase.proxy.cglib;

/**
 * @author zhao.cheng
 * @date 2020/9/8 16:07
 */
public class TestCglib {

    public static void main(String[] args) {
        AliSmsService proxy = (AliSmsService)CglibProxyFactory.getProxy(AliSmsService.class);
        proxy.send("java");
    }
}
