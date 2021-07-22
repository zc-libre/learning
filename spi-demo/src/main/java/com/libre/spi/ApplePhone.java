package com.libre.spi;

import com.google.auto.service.AutoService;

/**
 * @author ZC
 * @date 2021/7/22 15:20
 */
//@AutoService(Phone.class)
public class ApplePhone implements Phone {
    @Override
    public void call() {
        System.out.println("apple phone");
    }
}
