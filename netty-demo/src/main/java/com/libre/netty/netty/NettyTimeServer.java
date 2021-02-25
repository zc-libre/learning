package com.libre.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @author zhao.cheng
 * @date 2021/2/24 14:35
 */
public class NettyTimeServer {

   public void bind(int port) throws Exception {
       NioEventLoopGroup bossGroup = new NioEventLoopGroup();
       NioEventLoopGroup workerGroup = new NioEventLoopGroup();

       try {
           ServerBootstrap b = new ServerBootstrap();
           b.group(bossGroup, workerGroup)
                   .channel(NioServerSocketChannel.class)
                   .option(ChannelOption.SO_BACKLOG, 1024)
                   .childHandler(new ChildChannelHandler());
           ChannelFuture channelFuture = b.bind(port).sync();
           channelFuture.channel().closeFuture().sync();
       } finally {
           bossGroup.shutdownGracefully();
           workerGroup.shutdownGracefully();
       }

   }
    private static class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

        @Override
        protected void initChannel(SocketChannel socketChannel) throws Exception {
            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
            socketChannel.pipeline().addLast(new StringDecoder());
            socketChannel.pipeline().addLast(new TimeServerHandler());
        }
    }

    public static void main(String[] args) throws Exception {

        new NettyTimeServer().bind(8080);
    }
}


