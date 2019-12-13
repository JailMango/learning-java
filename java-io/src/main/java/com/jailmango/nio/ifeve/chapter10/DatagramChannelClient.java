package com.jailmango.nio.ifeve.chapter10;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DatagramChannelClientCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-09
 * @see com.jailmango.nio.ifeve.chapter10
 * @since R9.0
 */
public class DatagramChannelClient {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DatagramChannelClient.class);

    /**
     * port
     */
    private int port;

    /**
     * destIP
     */
    private String destIP;

    /**
     * destPort
     */
    private int destPort;

    /**
     * datagramChannel
     */
    private DatagramChannel datagramChannel;

    /**
     * destAddr
     */
    private SocketAddress destAddr;

    /**
     * constructor
     * 
     * @param port int
     * @param destIP String
     * @param destPort int
     */
    public DatagramChannelClient(int port, String destIP, int destPort) {
        this.port = port;
        this.destIP = destIP;
        this.destPort = destPort;
    }

    /**
     * initial
     * 
     * @throws IOException IOException
     */
    public void init() throws IOException {
        datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(this.port));

        destAddr = new InetSocketAddress(this.destIP, this.destPort);
    }

    public void connect() throws IOException {
        datagramChannel.connect(new InetSocketAddress("127.0.0.1", 8989));
    }

    /**
     * send
     * 
     * @throws IOException IOException
     */
    public void send() throws IOException {
        int count = 0;
        ByteBuffer buffer = ByteBuffer.allocate(20);

        while (count < 20) {
            buffer.clear();

            String msg = "Now: [" + System.currentTimeMillis() + "]";
            buffer.put(msg.getBytes(StandardCharsets.UTF_8));
            buffer.flip();

            datagramChannel.send(buffer, destAddr);
            logger.info("loop: [{}], send: [{}]", ++count, msg);

            try {
                Thread.sleep(300);
            }
            catch (InterruptedException e) {
                logger.error(e.getMessage());
            }
        }
    }

    /**
     * close
     * 
     * @throws IOException IOException
     */
    public void close() throws IOException {
        datagramChannel.close();
        logger.info("UDP Close...");
    }
}
