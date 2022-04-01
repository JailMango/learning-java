package com.jailmango.concurrence.book.action.chapter05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_10_3_使用NIO实现客户端
 *
 * @author jailmango
 * @CreateDate 2020/11/4
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_10_3_NIO_Client {

    private Selector selector;

    public void init(String ip, int port) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        this.selector = SelectorProvider.provider().openSelector();
        socketChannel.connect(new InetSocketAddress(ip, port));
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
    }

    public void working() throws IOException {
        while (true) {
            if (!selector.isOpen()) {
                break;
            }

            selector.select();
            Iterator<SelectionKey> iterator = this.selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if (selectionKey.isConnectable()) {
                    connect(selectionKey);
                }
                else if (selectionKey.isReadable()) {
                    read(selectionKey);
                }
            }
        }
    }

    public void connect(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        if (socketChannel.isConnectionPending()) {
            socketChannel.finishConnect();
        }

        socketChannel.configureBlocking(false);
        socketChannel.write(ByteBuffer.wrap("Hello World".getBytes()));
        socketChannel.register(this.selector, SelectionKey.OP_READ);
    }

    public void read(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        socketChannel.read(byteBuffer);
        byte[] data = byteBuffer.array();
        String msg = new String(data).trim();
        log.info("read message[{}]...", msg);
        socketChannel.close();
        selectionKey.selector().close();
    }
}
