package com.libre.netty.nio.time;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhao.cheng
 * @date 2021/2/24 10:31
 */
public class MultiplexerTimeServer implements Runnable {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private volatile boolean stop;

    /**
     * 资源初始化吗创建多路复用器Selector、ServerSocketChannel，对Channel和TCP参数进行配置。
     * eg: 将ServerSocketChannel设置为异步非阻塞模式， 他的backlog设置为1024。
     * 系统资源初始化成功后， 将ServerSocketChannel注册到Selector,监听SelectionKey.OP_ACCEPT；
     * @param port 端口
     */
    public MultiplexerTimeServer(int port) {
        try {
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("the time server is start in port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    /**
     * 在循环体内循环遍历selector，他的休眠时间为1s,无论是否有读写事件发生，selector每隔1s都会被唤醒一次，
     * selector也提供了一个无参的select方法。当有处于就绪创天的channel时， selector将返回绪状态的channel的
     * selectionKey集合，通过对就绪状态的channel集合进行迭代，可以进行网络的异步读写操作。
     */
    @Override
    public void run() {
       while (!stop) {
           try {
               selector.select(1000);
               Set<SelectionKey> selectionKeys = selector.selectedKeys();
               Iterator<SelectionKey> iterator = selectionKeys.iterator();
               SelectionKey key = null;
               while (iterator.hasNext()) {
                   key = iterator.next();
                   iterator.remove();
                   try {
                       handleInput(key);
                   } catch (Exception e) {
                       key.cancel();
                       if (key.channel() != null) {
                           key.channel().close();
                       }

                   }
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

       if (selector != null) {
           try {
               selector.close();
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
    }

    /**
     * 处理新接入的客户端请求消息， 根据selectionKey的操作位进行判断即可获知网络事件的类型，
     * 通过ServerSocketChannel的accept接收客户端的连接请求并创建SocketChannel实例，完成
     * 上述操作后，相当于完成了TCP的三次握手，TCP物理链路正式建立。注意，我们需要将新创建的SocketChannel
     * 设置为异步非阻塞，同时也可以对其TCP参数进行设置。
     * @param key /
     * @throws IOException /
     */
    private void handleInput(SelectionKey key) throws IOException{
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = channel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = socketChannel.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, StandardCharsets.UTF_8);
                    System.out.println("the time server receive order: " + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? LocalDateTime.now().toString() : "BAD ORDER";
                    doWrite(socketChannel, currentTime);
                }else if (readBytes < 0) {
                    key.cancel();
                    socketChannel.close();
                }else {
                    // 没有读取到字节
                }
            }
         }
    }

    /**
     * 将应答消息返回给客户端
     * @param channel /
     * @param response /
     * @throws IOException /
     */
    private void doWrite(SocketChannel channel, String response) throws IOException {
        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }
}
