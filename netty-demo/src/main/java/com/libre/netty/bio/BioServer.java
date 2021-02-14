package com.libre.netty.bio;

import com.libre.netty.util.ThreadUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author zhao.cheng
 * @Date 2021/2/8
 */

public class BioServer {

    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor executor = ThreadUtils.executor();

        ServerSocket serverSocket = new ServerSocket(8081);
        System.out.println("服务器启动了");

       while (true) {
           System.out.println("线程信息： id: " + Thread.currentThread().getId() + "," + "线程信息： name: " + Thread.currentThread().getName());

           System.out.println("等待连接......");
           final Socket socket = serverSocket.accept();
           System.out.println("连接到一个客户端");

           executor.execute(() -> handle(socket));
       }
    }

    public static void handle(Socket socket) {

        try (InputStream in = socket.getInputStream()){

            System.out.println("线程信息： id: " + Thread.currentThread().getId() + "," + "线程信息： name: " + Thread.currentThread().getName());

            byte[] buffer = new byte[1024];

            System.out.println("等待读取数据......");
            while (in.read(buffer) != -1) {
                System.out.println("线程信息： id: " + Thread.currentThread().getId() + "," + "线程信息： name: " + Thread.currentThread().getName());

                String line = new String(buffer, 0, buffer.length);
                System.out.println("接收到消息：[" + line + "]" );
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
