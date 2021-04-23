package com.zc.pattern.responsibilitychain;

/**
 * @author zhao.cheng
 * @date 2021/4/22 16:19
 */
public class HandlerB implements Handler {

    @Override
    public boolean doHandle() {
        return false;
    }
}
