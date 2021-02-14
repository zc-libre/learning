package com.libre.netty.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author zhao.cheng
 * @date 2021/2/8
 */
public class NioFileChannel {
    public static void main(String[] args) throws IOException {
        String str = "hello, netty";

        File file = new File("a.txt");
        // 创建一个输出流
        FileOutputStream out = new FileOutputStream(file);
        // 通过stream 获取对应的FileChannel
        FileChannel fileChannel = out.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(str.getBytes(StandardCharsets.UTF_8));

        buffer.flip();

        fileChannel.write(buffer);
        out.close();

        FileInputStream in = new FileInputStream(file);
        FileChannel channel = in.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(((int) file.length()));
        channel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));
    }
}
