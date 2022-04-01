package com.jailmango.nio.ifeve.chapter08;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * SocketChannelCase
 *
 * @author jailmango
 * @CreateDate 2019-04-09
 * @see com.jailmango.nio.ifeve.chapter08
 * @since R9.0
 */
public class SocketChannelCase {

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 8989));

        ByteBuffer buffer = ByteBuffer.allocate(20);
        buffer.put("Hello".getBytes(StandardCharsets.UTF_8));
        buffer.flip();

        socketChannel.write(buffer);

        socketChannel.close();
    }
}
