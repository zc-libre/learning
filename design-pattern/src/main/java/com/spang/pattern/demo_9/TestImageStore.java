package com.spang.pattern.demo_9;

import com.spang.pattern.demo_9.impl.AliyunImageStore;
import com.spang.pattern.demo_9.service.ImageStore;

/**
 * @author zhao.cheng
 */
public class TestImageStore {
    public static void main(String[] args) {
        ImageStore imageStore = new AliyunImageStore();

    }
}
