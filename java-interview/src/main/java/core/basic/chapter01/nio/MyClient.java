package core.basic.chapter01.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

import lombok.extern.slf4j.Slf4j;

/**
 * MyClient
 *
 * @author jailmango
 * @CreateDate 2020/12/22
 * @see core.basic.chapter01.nio
 * @since R9.0
 */
@Slf4j
public class MyClient {

    private int size = 1024;

    private ByteBuffer byteBuffer;

    private SocketChannel socketChannel;

    public void connectServer() throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 9999));
        socketChannel.configureBlocking(false);
        byteBuffer = ByteBuffer.allocate(size);
        receive();
    }

    private void receive() throws IOException {
        while (true) {
            byteBuffer.clear();
            int count;
            while ((count = socketChannel.read(byteBuffer)) > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                sendToServer("say hi...".getBytes(StandardCharsets.UTF_8));
                byteBuffer.clear();
            }
        }
    }

    private void sendToServer(byte[] bytes) throws IOException {
        byteBuffer.clear();
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws IOException {
        new MyClient().connectServer();
    }
}
