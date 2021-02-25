package com.libre.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhao.cheng
 * @date 2021/2/23 15:40
 */
public class NioServer {
    public static void main(String[] args) throws IOException {
        // 创建ServerSocketChannel -> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        Selector selector = Selector.open();
        // 绑定一个端口6666 在服务端监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        // 设为非阻塞
        serverSocketChannel.configureBlocking(false);
        // 把serverSocketChannel 注册到 selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        // 循环等待客户端连接
        while (true) {
            // 等待1秒， 如果没有事件发生， 返回
            if (selector.select(1000) == 0) {
                System.out.println("服务器等待了1秒， 无连接");
                continue;
            }
            // 如果返回> 0, 就获取相关的selectionKey集合
            // 如果返回大于0，表示已经获取到关注的事件
            // selector.selectedKeys() 返回关注事件的集合，
            // 通过selectionKeys 反向获取通道
            Set<SelectionKey> selectionKeys = selector.selectedKeys();

            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 根据key对应的通道发生的事件做相应处理
                // 如果是OP_ACCEPT ,有新的客户端连接
                if (key.isAcceptable()) {
                    // 获取socketChannel
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    System.out.println("客户端连接成功, 生成了一个socketChannel");

                    socketChannel.configureBlocking(false);
                    socketChannel.socket().setReuseAddress(true);
                    // 将socketChannel注册到selector, 关注事件为 OP_READ， 同时将socketChannel关联一个buffer
                    socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                // 发生OP_READ
                if (key.isReadable()) {
                    // 通过key 反向获取到channel
                    SocketChannel channel = (SocketChannel) key.channel();
                    // 获取该channel获取到关联的buffer
                    ByteBuffer buffer = (ByteBuffer) key.attachment();
                    channel.read(buffer);
                    System.out.println("from 客户端" + new String(buffer.array()));
                }
                iterator.remove();
            }

         }

    }
}
