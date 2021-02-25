package com.libre.netty.nio;

import java.io.IOException;
import java.nio.channels.Selector;

/**
 * @author zhao.cheng
 * @date 2021/2/23 15:37
 */
public class SelectorTest {
    public static void main(String[] args) throws IOException {
        Selector open = Selector.open();
    }
}
