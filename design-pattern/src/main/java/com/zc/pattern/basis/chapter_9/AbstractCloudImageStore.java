package com.zc.pattern.basis.chapter_9;

import com.zc.pattern.basis.chapter_9.service.ImageStore;

/**
 * @author zhao.cheng
 */
public abstract class AbstractCloudImageStore implements ImageStore {

    /**
     *  生成token
     * @return /
     */
    abstract protected String generateAccessToken();

    /**
     * 创建bucket
     * @param bucketName /
     */
    abstract protected void createBucketIfNotExisting(String bucketName);
}
