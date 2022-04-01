package com.jailmango.netty.lightman.netty.chat.server.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.jailmango.netty.lightman.netty.chat.counter.ClientCounter;

/**
 * LifeCycleHandler
 *
 * @author jailmango
 * @CreateDate 2019-08-16
 * @see com.jailmango.netty.lightman.netty.chat.server.handler
 * @since R9.0
 */
public class LifeCycleHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LifeCycleHandler.class);

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        logger.info("handlerAdded -> handler被添加");
        super.handlerAdded(ctx);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        logger.info("handlerRemoved -> handler被移除");
        super.handlerRemoved(ctx);
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelRegistered -> channel绑定到线程[NioEventLoop]");
        super.channelRegistered(ctx);
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelUnregistered -> channel取消线程[NioEventLoop]的绑定");
        super.channelUnregistered(ctx);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelActive -> channel准备就绪");

        ClientCounter.INSTANCE.connect();
        logger.info("One Client connect...");

        super.channelActive(ctx);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelInactive -> channel被关闭");

        ClientCounter.INSTANCE.disconnect();
        logger.info("One Client disconnect...");

        super.channelInactive(ctx);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("channelRead -> channel有数据可读");
        super.channelRead(ctx, msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("channelReadComplete -> channel某次数据读完");
        super.channelReadComplete(ctx);
    }
}
