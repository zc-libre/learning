package com.zc.pattern.responsibilitychain;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhao.cheng
 * @date 2021/4/22 16:21
 */
public class HandlerChain {

    private List<Handler> handlers = new ArrayList<>();

    public void addHandler(Handler handler) {
        this.handlers.add(handler);
    }

    public void handler() {
        for (Handler handler : handlers) {
            boolean handled = handler.doHandle();
            if (handled) {
                break;
            }
        }
    }
}
