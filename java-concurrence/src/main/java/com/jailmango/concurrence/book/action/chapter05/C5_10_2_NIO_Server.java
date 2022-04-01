package com.jailmango.concurrence.book.action.chapter05;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_10_2_基于NIO服务端的多线程
 *
 * @author jailmango
 * @CreateDate 2020/11/1
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_10_2_NIO_Server {

    private Selector selector;

    private ExecutorService executorService = Executors.newCachedThreadPool();

    public static Map<Socket, Long> timeStat = new HashMap<>(10240);

    private void startServer() throws IOException {
        selector = SelectorProvider.provider().openSelector();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 8000);
        serverSocketChannel.socket().bind(inetSocketAddress);

        SelectionKey acceptKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            long e = 0;

            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                iterator.remove();

                if (selectionKey.isAcceptable()) {
                    doAccept(selectionKey);
                }
                else if (selectionKey.isValid() && selectionKey.isReadable()) {
                    if (timeStat.containsKey(((SocketChannel) selectionKey.channel()).socket())) {
                        timeStat.put(((SocketChannel) selectionKey.channel()).socket(), System.currentTimeMillis());
                        doRead(selectionKey);
                    }
                }
                else if (selectionKey.isValid() && selectionKey.isWritable()) {
                    doWrite(selectionKey);
                    long current = System.currentTimeMillis();
                    log.info("spend {}...",
                        current - timeStat.remove(((SocketChannel) selectionKey.channel()).socket()));
                }
            }
        }
    }

    private void doAccept(SelectionKey selectionKey) {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
        SocketChannel clientSocketChannel;

        try {
            clientSocketChannel = serverSocketChannel.accept();
            clientSocketChannel.configureBlocking(false);

            // Register this channel for reading
            SelectionKey clientSelectionKey = clientSocketChannel.register(selector, SelectionKey.OP_READ);
            // Allocate an EchoClient instance and attach it to this selection key
            EchoClient echoClient = new EchoClient();
            clientSelectionKey.attach(echoClient);

            InetAddress inetAddress = clientSocketChannel.socket().getInetAddress();
            log.info("Accepted connection from {}...", inetAddress.getHostAddress());
        }
        catch (IOException e) {
            log.warn("Failed to accept new client...");
            e.printStackTrace();
        }
    }

    private void doRead(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(8192);

        int length;

        try {
            length = socketChannel.read(byteBuffer);

            if (length < 0) {
                disconnect(selectionKey);
                return;
            }
        }
        catch (IOException e) {
            log.warn("Failed to read from client...");
            e.printStackTrace();
            disconnect(selectionKey);
            return;
        }

        byteBuffer.flip();
        executorService.execute(new HandleMsg(selectionKey, byteBuffer));
    }

    private void doWrite(SelectionKey selectionKey) {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        EchoClient echoClient = (EchoClient) selectionKey.attachment();
        LinkedList<ByteBuffer> outq = echoClient.getOutq();

        ByteBuffer byteBuffer = outq.getLast();

        try {
            int length = socketChannel.write(byteBuffer);
            if (length == -1) {
                disconnect(selectionKey);
                return;
            }

            if (byteBuffer.remaining() == 0) {
                outq.removeLast();
            }
        }
        catch (IOException e) {
            log.warn("Failed to write to client...");
            e.printStackTrace();
            disconnect(selectionKey);
        }

        if (outq.size() == 0) {
            selectionKey.interestOps(SelectionKey.OP_READ);
        }
    }

    private void disconnect(SelectionKey selectionKey) {

    }

    private class HandleMsg implements Runnable {

        private SelectionKey selectionKey;

        private ByteBuffer byteBuffer;

        public HandleMsg(SelectionKey selectionKey, ByteBuffer byteBuffer) {
            this.selectionKey = selectionKey;
            this.byteBuffer = byteBuffer;
        }

        @Override
        public void run() {
            EchoClient echoClient = (EchoClient) selectionKey.attachment();
            echoClient.enqueue(byteBuffer);
            selectionKey.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
            selector.wakeup();
        }
    }

    private class EchoClient {

        private LinkedList<ByteBuffer> outq;

        public EchoClient() {
            outq = new LinkedList<>();
        }

        public void enqueue(ByteBuffer byteBuffer) {
            outq.add(byteBuffer);
        }

        public LinkedList<ByteBuffer> getOutq() {
            return outq;
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }
}
