package com.jailmango.netty.lightman.jdk.io;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IOClient
 *
 * @author jailmango
 * @CreateDate 2019-07-29
 * @see com.jailmango.netty.lightman.chapter01
 * @since R9.0
 */
public class IOClient {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(IOClient.class);

    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Client());
        Thread b = new Thread(new Client());
        a.setName("Thread-A");
        b.setName("Thread-B");

        a.start();
        Thread.sleep(1300);
        b.start();
    }

    static class Client implements Runnable {

        @Override
        public void run() {
            try {
                Socket socket = new Socket("127.0.0.1", 8080);

                while (true) {
                    socket.getOutputStream().write(("Client - " + new Date()).getBytes());
                    socket.getOutputStream().flush();
                    Thread.sleep(3000);
                }
            }
            catch (IOException | InterruptedException e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
