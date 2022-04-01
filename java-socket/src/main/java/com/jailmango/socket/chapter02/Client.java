package com.jailmango.socket.chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Client
 *
 * @author jailmango
 * @CreateDate 2019-04-02
 * @see com.jailmango.socket.chapter02
 * @since R9.0
 */
public class Client {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Client.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        // 超时时间3000ms
        socket.setSoTimeout(30000);
        // 连接本地2020端口，超时时间为3000ms
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(), 2000), 30000);

        logger.info("已发起服务器连接...");
        logger.info("客户端信息: [" + socket.getLocalAddress() + ":" + socket.getLocalPort() + "]");
        logger.info("服务端信息: [" + socket.getInetAddress() + ":" + socket.getPort() + "]");

        try {
            doingSomething(socket);
        }
        catch (IOException ex) {
            logger.error("发生异常");
        }

        socket.close();
        logger.info("客户端已退出");
    }

    /**
     * todo
     * 
     * @param client Socket
     * @throws IOException IOException
     */
    private static void doingSomething(Socket client) throws IOException {
        // 键盘输入流
        InputStream in = System.in;
        BufferedReader inBufferReader = new BufferedReader(new InputStreamReader(in));

        // 得到Socket输出流，并转换为打印流
        OutputStream outputStream = client.getOutputStream();
        PrintStream socketPrintStream = new PrintStream(outputStream);

        // 得到Soket输入流，并转换为BufferReader
        InputStream inputStream = client.getInputStream();
        BufferedReader socketBufferReader = new BufferedReader(new InputStreamReader(inputStream));

        boolean flag = true;

        do {
            // 键盘读取一行
            String line = inBufferReader.readLine();
            // 发送到服务器
            socketPrintStream.println(line);

            // 从服务器读取一行
            String echo = socketBufferReader.readLine();

            if ("88".equals(echo)) {
                flag = false;
            }
            else {
                logger.info("Receive: [" + echo + "]");
            }
        }
        while (flag);
    }
}
