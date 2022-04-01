package com.jailmango.nio.ifeve.chapter06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIOServer
 *
 * @author jailmango
 * @CreateDate 2019-04-08
 * @see com.jailmango.nio.ifeve.chapter06
 * @since R9.0
 */
public class NIOServer {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NIOServer.class);

    /**
     * Selector
     */
    private Selector selector;

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        NIOServer server = new NIOServer();
        server.initServer(8989);
        server.listen();
    }

    /**
     * initServer
     * 
     * @param port int
     * @throws IOException IOException
     */
    private void initServer(int port) throws IOException {
        logger.info("initial server...");

        // 创建Selector
        this.selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);

        logger.info("initial server end...");
    }

    /**
     * listen
     */
    private void listen() {
        logger.info("listen");

        while (true) {
            try {
                this.selector.select();
                Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
                SelectionKey key;

                while (iterator.hasNext()) {
                    key = iterator.next();
                    iterator.remove();

                    if (key.isAcceptable()) {
                        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.write(ByteBuffer.wrap("Hello Client...".getBytes(StandardCharsets.UTF_8)));
                        socketChannel.register(this.selector, SelectionKey.OP_READ);
                    }
                    else if (key.isReadable()) {
                        read(key);
                    }
                }
            }
            catch (IOException ex) {
                logger.error(ex.getMessage());
                break;
            }
        }
    }

    /**
     * read
     * 
     * @param key SelectionKey
     * @throws IOException IOException
     */
    private void read(SelectionKey key) throws IOException {
        logger.info("read...");

        SocketChannel socketChannel = (SocketChannel) key.channel();
        ByteBuffer inBuffer = ByteBuffer.allocate(20);
        socketChannel.read(inBuffer);

        byte[] data = inBuffer.array();
        logger.info("receive message from client: [{}]", new String(data, StandardCharsets.UTF_8));

        ByteBuffer outBuffer = ByteBuffer.wrap(data);
        socketChannel.write(outBuffer);

        logger.info("read end...");
    }
}
