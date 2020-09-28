package com.zc.javase.proxy.jdk;

/**
 * @author zhao.cheng
 * @date 2020/9/8 15:35
 */
public class DebugProxy {

    private final Object object;

    public DebugProxy(Object object){
        this.object = object;
    }

    public <T> T getProxy(Class<T> clazz) {
        if (clazz.isInstance(object)) {
            Object proxy = JdkProxyFactory.getProxy(object);
            return clazz.cast(proxy);
        }
        return null;
    }
}
