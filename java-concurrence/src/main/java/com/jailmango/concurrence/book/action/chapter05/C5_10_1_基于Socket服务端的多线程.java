package com.jailmango.concurrence.book.action.chapter05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_10_1_NIO
 *
 * @author he.gang33
 * @CreateDate 2020/11/1
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_10_1_基于Socket服务端的多线程 {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private static class MsgHandler implements Runnable {

        private Socket clientSocket;

        public MsgHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            BufferedReader is = null;
            PrintWriter os = null;

            try {
                is = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }
}
