package com.zc.javase.proxy.jdk;

import java.lang.reflect.Proxy;

/**
 * @author zhao.cheng
 * @date 2020/9/8 15:31
 */
public class JdkProxyFactory {

    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new DebugInvocationHandler(target)
        );
    }
}
