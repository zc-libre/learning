package com.zc.javase.enums.collection;

/**
 * @author zhao.cheng
 * @date 2020/9/8 14:44
 */
public class TestEnums {

    public static void main(String[] args) {
        System.out.println(PinType.FORGET_PASSWORD.getCode());
        System.out.println(PinType.FORGET_PASSWORD.getMessage());
        System.out.println(PinType.FORGET_PASSWORD.toString());
    }
}
