package com.zc.javase.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author zhao.cheng
 * @date 2020/9/8 16:04
 */
public class CglibProxyFactory {

    public static Object getProxy(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new DebugMethodInterceptor());
        return enhancer.create();
    }
}
