package com.libre.netty.util;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhao.cheng
 * @Date 2021/2/8
 */
public class ThreadUtils {

   private static final ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(2,
            5,
            10, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(10),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

   public static ThreadPoolExecutor executor() {
       return EXECUTOR;
   }
}
