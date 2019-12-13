package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_9 - 1.2.9 模拟Servlet可能出现的非线程安全问题
 *
 * @author he.gang33
 * @CreateDate 2019-05-20
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_2_9 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_2_9.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Thread ath = new Thread(new ALogin());
        ath.start();

        Thread bth = new Thread(new BLogin());
        bth.start();

    }

    static class LoginServlet {

        /**
         * usernameRef
         */
        private static String usernameRef;

        /**
         * passwordRef
         */
        private static String passwordRef;

        /**
         * doPost - 加上synchronized，可避免线程不安全的问题
         * 
         * @param username String
         * @param password String
         */
        public static synchronized void doPost(String username, String password) {
            usernameRef = username;

            // 模拟并发操作，造成线程不安全问题
            if ("a".equals(username)) {
                try {
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    logger.info(e.getLocalizedMessage());
                }
            }

            passwordRef = password;

            logger.info("Username: [{}], Password: [{}]", usernameRef, passwordRef);
        }
    }

    static class ALogin implements Runnable {

        @Override
        public void run() {
            LoginServlet.doPost("a", "a");
        }
    }

    static class BLogin implements Runnable {

        @Override
        public void run() {
            LoginServlet.doPost("b", "b");
        }
    }
}
