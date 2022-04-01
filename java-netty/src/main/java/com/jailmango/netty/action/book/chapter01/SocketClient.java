package com.jailmango.netty.action.book.chapter01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SocketClient
 *
 * @author jailmango
 * @CreateDate 2019-04-30
 * @see com.jailmango.netty.action.book.chapter01
 * @since R9.0
 */
public class SocketClient {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SocketClient.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        PrintWriter print = new PrintWriter(socket.getOutputStream());
        String msg = "Hello Server!";
        print.write(msg);
        logger.info("Client Send: [{}]", msg);
        print.close();
    }
}
