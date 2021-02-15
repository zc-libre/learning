package com.libre.netty.nio;

import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author zhao.cheng
 * @date 2021/2/14
 */
public class ScatteringAndGatheringTest {
    public static void main(String[] args) throws Exception{

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        // 绑定socket ,并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLength = 8;

        while (true) {
            int byteRead = 0;

            while (byteRead < messageLength) {
                long length = socketChannel.read(byteBuffers);
                byteRead += length;
                System.out.println("byteRead = " + byteRead);
                Arrays.stream(byteBuffers).forEach(byteBuffer -> {
                    System.out.println("position: " + byteBuffer.position() + ", limit: " + byteBuffer.limit());

                });
                System.out.println();
            }

            Arrays.stream(byteBuffers).forEach(Buffer::flip);
            long byteWrite = 0L;

            while (byteWrite < messageLength) {
                long length = socketChannel.write(byteBuffers);
                byteWrite += length;
            }
            Arrays.stream(byteBuffers).forEach(Buffer::clear);
            System.out.println("byteRead = " + byteRead + ", byteWrite = " + byteWrite + ", messageLength = " + messageLength);
        }
    }
}
