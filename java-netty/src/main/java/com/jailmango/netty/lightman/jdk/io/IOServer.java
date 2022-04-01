package com.jailmango.netty.lightman.jdk.io;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * IOServer
 *
 * @author jailmango
 * @CreateDate 2019-07-29
 * @see com.jailmango.netty.lightman.chapter01
 * @since R9.0
 */
public class IOServer {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(IOServer.class);

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080, 2);

            new Thread(() -> {
                while (true) {
                    try {
                        logger.info("waiting...");
                        Socket socket = serverSocket.accept();

                        new Thread(() -> {
                            try {
                                byte[] data = new byte[1024];
                                InputStream inputStream = socket.getInputStream();

                                while (true) {
                                    int length = inputStream.read(data);

                                    if (length != -1) {
                                        logger.info("Read Data: [{}]", new String(data, 0, length));
                                    }
                                }
                            }
                            catch (IOException e) {
                                logger.error(e.getMessage());
                                e.printStackTrace();
                            }
                        }).start();
                    }
                    catch (IOException e) {
                        logger.error(e.getMessage());
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
