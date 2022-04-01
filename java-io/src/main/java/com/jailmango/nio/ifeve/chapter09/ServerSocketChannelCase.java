package com.jailmango.nio.ifeve.chapter09;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ServerSocketChannelCase
 *
 * @author jailmango
 * @CreateDate 2019-04-09
 * @see com.jailmango.nio.ifeve.chapter09
 * @since R9.0
 */
public class ServerSocketChannelCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ServerSocketChannel.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8989));
        serverSocketChannel.configureBlocking(false);

        int count = 0;

        while (count < 20) {
            SocketChannel socketChannel = serverSocketChannel.accept();

            if (null == socketChannel) {
                logger.info("no accept...");
            }

            logger.info("loop: [{}]", ++count);
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        }

        serverSocketChannel.close();
        logger.info("end...");
    }
}
