package com.jailmango.concurrence.imooc.note.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DaemonCase - Daemon线程
 *
 * @author jailmango
 * @CreateDate 2019-02-26
 * @see com.jailmango.imooc.note.chapter01
 * @since R9.0
 */
public class DaemonCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(DaemonCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        // A. 守护线程创建的过程中需要先调用setDaemon方法进行设置, 然后再启动线程. 否则会报出IllegalThreadStateException异常.
        // B. 由于daemon线程的终止条件是当前是否存在用户线程, 所以我们不能指派daemon线程来进行一些业务操作, 而只能服务用户线程.
        // C. daemon线程创建的子线程任然是daemon线程.

        logger.debug("Main Thread is running...");

        case2();

        logger.debug("Main Thread stopped...");
    }

    /**
     * 测试特性A和特性B
     */
    public static void case1() {
        Thread thread = new Thread(new DaemonThread());
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    /**
     * 测试特性C
     */
    public static void case2() {
        Thread thread = new Thread(new DaemonThreadParent());
        thread.setDaemon(true);
        thread.start();
        logger.debug("Parent Thread[" + thread.getName() + "] is daemon thread [" + thread.isDaemon() + "]...");

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }
    }

    static class DaemonThread implements Runnable {

        /**
         * logger
         */
        private static final Logger logger = LoggerFactory.getLogger(DaemonThread.class);

        @Override
        public void run() {
            logger.debug("Daemon Thread[" + Thread.currentThread().getName() + "] is running...");

            try {
                logger.debug("before sleeping...");
                Thread.sleep(3000);
                logger.debug("after sleeping...");
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }

            logger.debug("Daemon Thread[" + Thread.currentThread().getName() + "] stopped...");
        }
    }

    static class DaemonThreadParent implements Runnable {

        /**
         * logger
         */
        private static final Logger logger = LoggerFactory.getLogger(DaemonThreadParent.class);

        @Override
        public void run() {
            logger.debug("Parent Daemon Thread[" + Thread.currentThread().getName() + "] is running...");

            Thread subThread = new Thread(new DaemonThread());
            subThread.start();
            logger.debug("Sub Thread[" + subThread.getName() + "] is daemon thread [" + subThread.isDaemon() + "]...");

            logger.debug("Parent Daemon Thread[" + Thread.currentThread().getName() + "] stopped...");
        }
    }
}
