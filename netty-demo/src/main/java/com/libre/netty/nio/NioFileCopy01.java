package com.libre.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @author zhao.cheng
 * @Date 2021/2/9
 */
public class NioFileCopy01 {
    public static void main(String[] args) throws Exception{

        FileInputStream fileInputStream = new FileInputStream("a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("b.txt");

        FileChannel source = fileInputStream.getChannel();
        FileChannel target = fileOutputStream.getChannel();

        target.transferFrom(source, 0, source.size());

        source.close();
        target.close();
        fileInputStream.close();
        fileOutputStream.close();
    }
}
