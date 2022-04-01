package com.jailmango.netty.action.book.chapter01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_1 - 代码清单1-1 阻塞I/O示例
 *
 * @author jailmango
 * @CreateDate 2019-06-24
 * @see com.jailmango.netty.action.book.chapter01
 * @since R9.0
 */
public class Case1_1_Server {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_1_Server.class);

    public static void main(String[] args) {
        try {
            // 创建一个ServerSocket用以监听指定端口上的连接请求
            ServerSocket serverSocket = new ServerSocket(9999);
            // 对accept()方法的调用将被阻塞，直到一个连接建立
            Socket clientSocket = serverSocket.accept();
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // 获取输出流
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

            String request;
            String response;

            while (true) {
                while (null != (request = br.readLine())) {
                    if ("done".equals(request)) {
                        logger.info("Server end...");
                        break;
                    }
                    response = processRequest(request);
                    pw.println(response);
                }
            }
        }
        catch (IOException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    private static String processRequest(String request) {
        logger.info("Read Data: [{}]", request);
        return request + " - response";
    }
}
