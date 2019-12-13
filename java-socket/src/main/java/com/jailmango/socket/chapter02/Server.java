package com.jailmango.socket.chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Server
 *
 * @author he.gang33
 * @CreateDate 2019-04-02
 * @see com.jailmango.socket.chapter02
 * @since R9.0
 */
public class Server {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws IOException IOException
     */
    public static void main(String[] args) throws IOException {
        // 监听本地2000端口
        ServerSocket server = new ServerSocket(2000);

        logger.info("服务器已启动...");
        logger.info("服务端信息: [" + server.getInetAddress() + ":" + server.getLocalPort() + "]");

        // 等待客户端连接
        for (;;) {
            // 得到客户端
            Socket client = server.accept();
            // 客户端构建异步线程
            ClientHandler clientHandler = new ClientHandler(client);
            // 启动线程
            clientHandler.start();
        }

    }

    /**
     * 客户端消息处理
     */
    private static class ClientHandler extends Thread {

        /**
         * socket
         */
        private Socket socket;

        /**
         * flag
         */
        private boolean flag = true;

        /**
         * Constructor
         * 
         * @param socket Socket
         */
        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            logger.info("新客户端信息: [" + socket.getInetAddress() + ":" + socket.getPort() + "]");

            try {
                // 得到打印流，用于数据输出；服务器回送数据使用
                PrintStream socketOutput = new PrintStream(socket.getOutputStream());
                // 得到输入流，用于接收数据
                BufferedReader socketInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                do {
                    // 从客户端拿到一条数据
                    String line = socketInput.readLine();

                    if ("88".equals(line)) {
                        flag = false;
                        // 回送
                        socketOutput.println("88");
                    }
                    else {
                        logger.info("接收信息: [" + line + "]");
                        socketOutput.println(line.length());
                    }
                }
                while (flag);
                socketInput.close();
                socketOutput.close();
            }
            catch (Exception ex) {
                logger.error("连接异常断开");
            }
            finally {
                try {
                    socket.close();
                }
                catch (IOException e) {
                    logger.error("close error");
                }
            }

            logger.info("客户端已关闭: [" + socket.getInetAddress() + ":" + socket.getPort() + "]");
        }
    }
}
