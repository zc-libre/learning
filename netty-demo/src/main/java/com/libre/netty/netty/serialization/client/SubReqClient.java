package com.libre.netty.netty.serialization.client;

import com.libre.netty.netty.serialization.handler.JdkDecoderChannelHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author zhao.cheng
 * @date 2021/2/25 10:08
 */
public class SubReqClient {

    private final ChannelInitializer<SocketChannel> handler;

    public SubReqClient(ChannelInitializer<SocketChannel> handler) {
        this.handler = handler;
    }

    public void connect(String host, int port) throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(handler);
            ChannelFuture channelFuture = bootstrap.connect(host, port).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
           group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new SubReqClient(new JdkDecoderChannelHandler(new SubReqClientHandler())).connect("127.0.0.1", 8080);
    }
}
