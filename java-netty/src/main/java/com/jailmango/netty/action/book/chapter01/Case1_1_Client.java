package com.jailmango.netty.action.book.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_1 - 代码清单1-1 阻塞I/O示例
 *
 * @author he.gang33
 * @CreateDate 2019-06-24
 * @see com.jailmango.netty.action.book.chapter01
 * @since R9.0
 */
public class Case1_1_Client {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_1_Client.class);

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 9999);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter print = new PrintWriter(socket.getOutputStream());
            String msg = "" + new Date();
            print.write(msg);
            logger.info("Client Send: [{}]", msg);
            print.close();
        }
        catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void processResponse(String response) {
        logger.info("Read Data: [{}]", response);
    }
}
