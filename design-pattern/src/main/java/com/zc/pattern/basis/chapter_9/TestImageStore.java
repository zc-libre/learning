package com.zc.pattern.basis.chapter_9;

import com.zc.pattern.basis.chapter_9.impl.AliyunImageStore;
import com.zc.pattern.basis.chapter_9.service.ImageStore;

/**
 * @author zhao.cheng
 */
public class TestImageStore {
    public static void main(String[] args) {
        ImageStore imageStore = new AliyunImageStore();

    }
}
