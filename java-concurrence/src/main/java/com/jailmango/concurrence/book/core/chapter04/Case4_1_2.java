package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case4_1_2 - 4.1.2 验证多代码块间的同步性 此示例说明不管在一个方法还是多个方法的环境中，哪个线程持有锁，哪个线程就执行业务
 * 其他线程只有等待锁被释放时再次争抢，抢到锁就开始执行业务，运行效果和使用synchronized一样
 * 
 * @author he.gang33
 * @CreateDate 2019/12/26
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_2.class);

    public static void main(String[] args) {
        MyService service = new MyService();

        ThreadA a1 = new ThreadA(service);
        a1.setName("A1");
        ThreadA a2 = new ThreadA(service);
        a2.setName("A2");
        ThreadB b1 = new ThreadB(service);
        b1.setName("B1");
        ThreadB b2 = new ThreadB(service);
        b2.setName("B2");

        a1.start();
        a2.start();
        b1.start();
        b2.start();
    }

    private static class ThreadA extends Thread {

        private MyService service;

        public ThreadA(MyService service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.doService1();
        }
    }

    private static class ThreadB extends Thread {

        private MyService service;

        public ThreadB(MyService service) {
            this.service = service;
        }

        @Override
        public void run() {
            service.doService2();
        }
    }

    private static class MyService {

        /**
         * ReentrantLock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * service 1
         */
        public void doService1() {
            lock.lock();

            try {
                logger.info("{} service1 start...", Thread.currentThread().getName());
                Thread.sleep(1000);
                logger.info("{} service1 end...", Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }

        }

        /**
         * service 2
         */
        public void doService2() {
            lock.lock();

            try {
                logger.info("{} service2 start...", Thread.currentThread().getName());
                Thread.sleep(2000);
                logger.info("{} service2 end...", Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }
}
