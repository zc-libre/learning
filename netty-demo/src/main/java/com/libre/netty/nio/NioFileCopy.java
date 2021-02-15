package com.libre.netty.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhao.cheng
 * @Date 2021/2/9
 */
public class NioFileCopy {
    public static void main(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("a.txt");
        FileChannel fileInputChannel = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("b.txt");
        FileChannel fileOutputChannel = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            byteBuffer.clear();
            int read = fileInputChannel.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            int write = fileOutputChannel.write(byteBuffer);
        }
        fileInputStream.close();
        fileOutputChannel.close();
    }
}
