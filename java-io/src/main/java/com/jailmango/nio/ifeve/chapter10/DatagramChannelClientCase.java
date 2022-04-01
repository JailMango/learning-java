package com.jailmango.nio.ifeve.chapter10;

import java.io.IOException;

/**
 * DatagramChannelClientCase
 *
 * @author jailmango
 * @CreateDate 2019-04-09
 * @see com.jailmango.nio.ifeve.chapter10
 * @since R9.0
 */
public class DatagramChannelClientCase {

    public static void main(String[] args) throws IOException {
        DatagramChannelClient client1 = new DatagramChannelClient(8987, "127.0.0.1", 8989);
        client1.init();
        client1.connect();
        client1.send();
        client1.close();
    }
}
