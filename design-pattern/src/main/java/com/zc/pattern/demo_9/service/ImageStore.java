package com.zc.pattern.demo_9.service;

import java.awt.*;

/**
 * @author zhao.cheng
 */
public interface ImageStore {

    /**
     * 上传方法
     * @param image /
     * @param bucketName /
     * @return /
     */
    String upload(Image image,String bucketName);

    /**
     * 下载方法
     * @param url /
     * @return /
     */
    Image download(String url);
}
