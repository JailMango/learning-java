package core.basic.chapter01.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import lombok.extern.slf4j.Slf4j;

/**
 * MyServer
 *
 * @author he.gang33
 * @CreateDate 2020/12/21
 * @see core.basic.chapter01.nio
 * @since R9.0
 */
@Slf4j
public class MyServer {

    /**
     * size
     */
    private int size = 1024;

    /**
     * ServerSocketChannel
     */
    private ServerSocketChannel serverSocketChannel;

    /**
     * ByteBuffer
     */
    private ByteBuffer byteBuffer;

    /**
     * Selector
     */
    private Selector selector;

    /**
     * number of remote client
     */
    private int remoteClientNum = 0;

    /**
     * Constructor
     * 
     * @param port int
     * @throws IOException IOException
     */
    public MyServer(int port) throws IOException {
        initChannel(port);
    }

    /**
     * initChannel
     * 
     * @param port int
     * @throws IOException IOException
     */
    private void initChannel(int port) throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(port));

        log.info("listener on port: {}", port);

        selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        byteBuffer = ByteBuffer.allocate(size);
    }

    private void listener() throws IOException {
        while (true) {
            int n = selector.select();
            if (n == 0) {
                continue;
            }

            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();

                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    registerChannel(selector, channel, SelectionKey.OP_READ);
                    remoteClientNum++;
                    log.info("online client: {}", remoteClientNum);
                    write(channel, "hello client...".getBytes(StandardCharsets.UTF_8));
                }

                if (key.isReadable()) {
                    read(key);
                }

                iterator.remove();
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        int count;
        byteBuffer.clear();
        while ((count = socketChannel.read(byteBuffer)) > 0) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
        }

        if (count < 0) {
            socketChannel.close();
        }
    }

    private void write(SocketChannel socketChannel, byte[] data) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(data);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }

    private void registerChannel(Selector selector, SocketChannel socketChannel, int opRead) throws IOException {
        if (socketChannel == null) {
            return;
        }

        socketChannel.configureBlocking(false);
        socketChannel.register(selector, opRead);
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws IOException {
        MyServer myServer = new MyServer(9999);
        myServer.listener();
    }

}
