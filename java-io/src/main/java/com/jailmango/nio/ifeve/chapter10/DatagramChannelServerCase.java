package com.jailmango.nio.ifeve.chapter10;

import java.io.IOException;

/**
 * DatagramChannelClientCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-09
 * @see com.jailmango.nio.ifeve.chapter10
 * @since R9.0
 */
public class DatagramChannelServerCase {

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        DatagramChannelServer server = new DatagramChannelServer(8989);
        server.init();
        server.recevie();
        server.close();
    }
}
