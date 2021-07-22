package com.libre.spi;

import java.util.ServiceLoader;

/**
 * @author ZC
 * @date 2021/7/22 15:22
 */
public class SpiMain {
    public static void main(String[] args) {
        ServiceLoader<Phone> serviceLoader = ServiceLoader.load(Phone.class);

        for (Phone phone : serviceLoader) {
            phone.call();
        }
    }
}
