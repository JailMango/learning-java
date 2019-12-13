package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_24 - 2.2.24 锁对象不变依然同步执行
 *
 * @author he.gang33
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_24 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_24.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        User user = new User("mango", "11");

        MyThread1 a = new MyThread1("Thread-A", service, user);
        MyThread2 b = new MyThread2("Thread-B", service, user);

        a.start();
        Thread.sleep(100);
        b.start();

        // 本例中线程A与线程B是同步的。虽然User对象的属性改变，但是User对象未改变。线程A与线程B持有的锁对象是同一个，因此还是同步的。
    }

    static class MyThread1 extends Thread {

        /**
         * Service
         */
        private Service service;

        /**
         * User
         */
        private User user;

        /**
         * Constructor
         * 
         * @param name String
         * @param service Service
         * @param user User
         */
        public MyThread1(String name, Service service, User user) {
            super(name);
            this.service = service;
            this.user = user;
        }

        @Override
        public void run() {
            service.doService(user);
        }
    }

    static class MyThread2 extends Thread {

        /**
         * Service
         */
        private Service service;

        /**
         * User
         */
        private User user;

        /**
         * Constructor
         *
         * @param name String
         * @param service Service
         * @param user User
         */
        public MyThread2(String name, Service service, User user) {
            super(name);
            this.service = service;
            this.user = user;
        }

        @Override
        public void run() {
            service.doService(user);
        }
    }

    static class Service {

        public void doService(User user) {
            synchronized (user) {
                logger.info("Thread[{}] do service begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());

                user.setName(user.getName() + "-change");
                try {
                    Thread.sleep(3000);
                }
                catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage());
                }

                logger.info("Thread[{}] do service end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
        }
    }

    static class User {

        /**
         * name
         */
        private String name;

        /**
         * password
         */
        private String password;

        /**
         * Constructor
         * 
         * @param name String
         * @param password String
         */
        public User(String name, String password) {
            this.name = name;
            this.password = password;
        }

        /**
         * getName
         * 
         * @return String
         */
        public String getName() {
            return name;
        }

        /**
         * setName
         * 
         * @param name String
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * getPassword
         * 
         * @return String
         */
        public String getPassword() {
            return password;
        }

        /**
         * setPassword
         * 
         * @param password String
         */
        public void setPassword(String password) {
            this.password = password;
        }
    }
}
