package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_11_7
 *
 * @author jailmango
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_11_7 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_11_7.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThreadA threadA = new MyThreadA("Thread-A", service);
        threadA.start();
        Thread.sleep(100);

        MyThreadB threadB = new MyThreadB("Thread-B", service);
        threadB.start();
        Thread.sleep(3000);
        // stop()方法会导致锁释放的不正确，从而出现线程不安全的问题

        // 重要！为何该段程序会出现竞争锁的情况？ 因为synchronized关键字加在方法上，默认是当前对象作为锁的对象。因此线程A执行printMsg()时，对service对象加了锁。线程B执行get()时，未获取到锁。
        threadA.stop();
        logger.info("After stop()...");
    }

    static class MyThreadA extends Thread {

        /**
         * service
         */
        private Service service;

        /**
         * Constructor
         *
         * @param name String
         * @param service Service
         */
        public MyThreadA(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.printMsg("b", "bb");
        }
    }

    static class MyThreadB extends Thread {

        /**
         * service
         */
        private Service service;

        /**
         * Constructor
         *
         * @param name String
         * @param service Service
         */
        public MyThreadB(String name, Service service) {
            super(name);
            this.service = service;
        }

        @Override
        public void run() {
            service.getUsername();
            service.getPassword();
        }
    }

    static class Service {

        /**
         * username
         */
        private String username = "a";

        /**
         * password
         */
        private String password = "aa";

        /**
         * getUsername
         * 
         * @return String
         */
        public synchronized String getUsername() {
            logger.info("getUsername - Thread: [{}], Name: [{}]", Thread.currentThread().getName(), this.username);
            return username;
        }

        /**
         * getPassword
         * 
         * @return String
         */
        public synchronized String getPassword() {
            logger.info("getPassword - Thread: [{}], Password: [{}]", Thread.currentThread().getName(), this.password);
            return password;
        }

        /**
         * printMsg
         * 
         * @param username String
         * @param password String
         */
        public synchronized void printMsg(String username, String password) {
            try {
                this.username = username;
                logger.info("printMsg - Thread: [{}], Name: [{}]", Thread.currentThread().getName(), username);
                Thread.sleep(100000);
                this.password = password;
                logger.info("printMsg - Thread: [{}], Name: [{}]", Thread.currentThread().getName(), username);
            }
            catch (InterruptedException e) {
                logger.info(e.getLocalizedMessage());
            }
        }
    }
}
