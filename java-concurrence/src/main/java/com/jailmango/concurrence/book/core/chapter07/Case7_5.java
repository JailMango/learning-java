package com.jailmango.concurrence.book.core.chapter07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.5 实现线程执行有序性
 *
 * @author he.gang33
 * @CreateDate 2020/9/7
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_5.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyService service = new MyService();

        MyThread a = new MyThread(service, "A", 1);
        MyThread b = new MyThread(service, "B", 2);
        MyThread c = new MyThread(service, "C", 3);
        a.start();
        b.start();
        c.start();
    }

    private static class MyThread extends Thread {

        /**
         * service
         */
        private MyService service;

        /**
         * printMsg
         */
        private String printMsg;

        /**
         * index
         */
        private int index;

        /**
         * Constructor
         * 
         * @param service MyService
         * @param printMsg String
         * @param index int
         */
        public MyThread(MyService service, String printMsg, int index) {
            super();
            this.service = service;
            this.printMsg = printMsg;
            this.index = index;
        }

        @Override
        public void run() {
            service.doService(printMsg, index);
        }
    }

    private static class MyService {

        private static int currentPrintPosition = 0;

        private synchronized void doService(String msg, int index) {
            while (true) {
                if (currentPrintPosition == 3) {
                    currentPrintPosition = 0;
                }
                while ((index - 1) % 3 != currentPrintPosition) {
                    try {
                        this.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("[{}] -> [{}]", Thread.currentThread().getName(), msg);
                currentPrintPosition++;
                this.notifyAll();
            }
        }
    }

}
