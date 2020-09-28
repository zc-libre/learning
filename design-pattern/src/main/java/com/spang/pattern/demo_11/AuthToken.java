package com.spang.pattern.demo_11;

/**
 * @author zhao.cheng
 * @date 2020/8/13 16:36
 */
public class AuthToken {

    private static final long DEFAULT_EXPIRED_TIME_INTERVAL = 60000;
    private final String token;
    private final long createTime;
    private long expiredTimeInterval = DEFAULT_EXPIRED_TIME_INTERVAL;

    public AuthToken(String token, long createTime) {
        this.token = token;
        this.createTime = createTime;
    }

    public AuthToken(String token, long createTime, long expiredTimeInterval) {
        this.token = token;
        this.createTime = createTime;
        this.expiredTimeInterval = expiredTimeInterval;
    }

    public static AuthToken create(String baseUrl, long createTime) {
        return null;
    }

    public String getToken() {
        return this.token;
    }
}
