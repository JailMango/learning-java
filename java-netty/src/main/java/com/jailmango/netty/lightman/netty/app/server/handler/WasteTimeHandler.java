package com.jailmango.netty.lightman.netty.app.server.handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * WasteTimeHandler
 *
 * @author jailmango
 * @CreateDate 2019/12/12
 * @see com.jailmango.netty.lightman.netty.app.server.handler
 * @since R9.0
 */
@ChannelHandler.Sharable
public class WasteTimeHandler extends ChannelInboundHandlerAdapter {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WasteTimeHandler.class);

    /**
     * instance
     */
    public static final WasteTimeHandler INSTANCE = new WasteTimeHandler();

    /**
     * executorService
     */
    private ExecutorService executorService = new ThreadPoolExecutor(2, 2, 300, TimeUnit.MINUTES,
        new LinkedBlockingQueue<>());

    /**
     * Constructor
     */
    private WasteTimeHandler() {

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("耗时操作 开始...");

        // 一些耗时的操作，可以异步的，交给其他业务线程来做，避免影响nio线程处理其他channel
        executorService.submit(() -> {
            try {
                logger.info("业务线程[{}]处理中...", Thread.currentThread().getName());
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        logger.info("耗时操作 结束...");
        super.channelRead(ctx, msg);
    }
}
