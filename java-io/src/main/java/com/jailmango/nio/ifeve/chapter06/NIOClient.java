package com.jailmango.nio.ifeve.chapter06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * NIOClient
 *
 * @author jailmango
 * @CreateDate 2019-04-08
 * @see com.jailmango.nio.ifeve.chapter06
 * @since R9.0
 */
public class NIOClient {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(NIOClient.class);

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
        NIOClient client = new NIOClient();
        client.initClient("127.0.0.1", 8989);
        client.listen();
    }

    /**
     * initClient
     * 
     * @param ip String
     * @param port int
     * @throws IOException IOException
     */
    private void initClient(String ip, int port) throws IOException {
        logger.info("initial client...");

        this.selector = Selector.open();

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.connect(new InetSocketAddress(ip, port));
        socketChannel.register(this.selector, SelectionKey.OP_CONNECT);

        logger.info("initial client end...");
    }

    /**
     * listen
     */
    private void listen() {
        logger.info("listen...");

        int count = 0;

        while (count < 20) {
            try {
                this.selector.select();
                Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
                SelectionKey key;

                while (iterator.hasNext()) {
                    key = iterator.next();
                    iterator.remove();

                    if (key.isConnectable()) {
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        if (socketChannel.isConnectionPending()) {
                            socketChannel.finishConnect();
                        }

                        socketChannel.configureBlocking(false);
                        socketChannel.write(ByteBuffer.wrap("Hello NIO Server...".getBytes(StandardCharsets.UTF_8)));
                        socketChannel.register(this.selector, SelectionKey.OP_READ);
                    }
                    else if (key.isReadable()) {
                        count++;
                        read(key);
                    }
                }
            }
            catch (IOException e) {
                logger.error(e.getMessage());
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
        logger.info("receive message from server: [{}]", new String(data, StandardCharsets.UTF_8));

        ByteBuffer outBuffer = ByteBuffer.wrap(data);
        socketChannel.write(outBuffer);

        logger.info("read end...");
    }
}
