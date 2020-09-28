package com.spang.pattern.demo_9.impl;

import com.spang.pattern.demo_9.AbstractCloudImageStore;

import java.awt.*;

/**
 * @author zhao.cheng
 */
public class AliyunImageStore extends AbstractCloudImageStore {

    @Override
    protected String generateAccessToken() {
        return null;
    }

    @Override
    protected void createBucketIfNotExisting(String bucketName) {

    }

    public String upload(Image image, String bucketName) {
        return null;
    }

    public Image download(String url) {
        return null;
    }
}
