package com.libre.netty.netty.serialization.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @author zhao.cheng
 * @date 2021/2/25 9:53
 */
public class JdkDecoderChannelHandler extends ChannelInitializer<SocketChannel> {

    private final ChannelHandler channelHandler;

    public JdkDecoderChannelHandler(ChannelHandler channelHandler) {
        this.channelHandler = channelHandler;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ObjectDecoder objectDecoder = new ObjectDecoder(1024 * 1024,
                ClassResolvers.weakCachingConcurrentResolver(this.getClass().getClassLoader()));

        ch.pipeline().addLast(objectDecoder);
        ch.pipeline().addLast(new ObjectEncoder());
        ch.pipeline().addLast(channelHandler);
    }
}
