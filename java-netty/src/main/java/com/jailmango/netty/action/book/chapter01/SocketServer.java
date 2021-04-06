package com.jailmango.netty.action.book.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SocketServer - code1-1
 *
 * @author he.gang33
 * @CreateDate 2019-04-29
 * @see com.jailmango.netty.action.book.chapter01
 * @since R9.0
 */
public class SocketServer {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SocketServer.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        // 创建绑定到特定端口的服务器套接字
        ServerSocket serverSocket = new ServerSocket(8888);
        logger.info("Server start...");
        // 侦听并接受到此套接字的连接
        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String request = null;

        while (true) {
            while ((request = in.readLine()) != null) {
                logger.info("Server Receive: [{}]", request);
            }
        }
    }
}
