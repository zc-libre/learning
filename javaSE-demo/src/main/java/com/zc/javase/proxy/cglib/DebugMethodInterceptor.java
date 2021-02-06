package com.zc.javase.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author zhao.cheng
 * @date 2020/9/8 15:59
 */
public class DebugMethodInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before method " + method.getName());
        Object object = methodProxy.invokeSuper(o, args);
        System.out.println("after method " + method.getName());
        return object;

    }
}
