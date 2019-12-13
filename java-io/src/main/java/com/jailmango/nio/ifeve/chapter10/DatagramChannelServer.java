package com.jailmango.nio.ifeve.chapter10;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DatagramChannelServer
 *
 * @author he.gang33
 * @CreateDate 2019-04-09
 * @see com.jailmango.nio.ifeve.chapter10
 * @since R9.0
 */
public class DatagramChannelServer {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DatagramChannelServerCase.class);

    /**
     * MAX_INTERVAL
     */
    private static final Long MAX_INTERVAL = 100000L;

    /**
     * port
     */
    private int port;

    /**
     * DatagramChannel
     */
    private DatagramChannel datagramChannel;

    /**
     * interval
     */
    private Long interval = 0L;

    /**
     * startDate
     */
    private Long startDate;

    /**
     * constructor
     *
     * @param port int
     */
    public DatagramChannelServer(int port) {
        this.port = port;
        this.startDate = System.currentTimeMillis();
    }

    /**
     * initial
     * 
     * @throws IOException IOException
     */
    public void init() throws IOException {
        this.datagramChannel = DatagramChannel.open();
        datagramChannel.socket().bind(new InetSocketAddress(this.port));
    }

    /**
     * receive
     * 
     * @throws IOException IOException
     */
    public void recevie() throws IOException {
        logger.info("UDP Receive start...");
        int count = 0;
        ByteBuffer buffer = ByteBuffer.allocate(20);

        while (MAX_INTERVAL > this.interval) {
            datagramChannel.receive(buffer);
            logger.info("loop: [{}], UDP Receice: [{}]", ++count, new String(buffer.array()));
            this.interval = System.currentTimeMillis() - this.startDate;
        }

        logger.info("UDP Receive end...");
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
