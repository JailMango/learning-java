package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.2.2 ReentrantReadWriteLock类的使用 - 读读共享 <br/>
 * 从本例结果来看，使用lock.readLock()读锁可以提高运行效率 <br/>
 * 允许多个线程同时执行lock()方法后面的代码 <br/>
 * 为什么要是用锁呢？ <br/>
 * 因为可能有第三个线程执行写操作，读写操作不可同时进行，必须在写操作之后，<br/>
 * 再同时执行读操作，避免出现线程安全的问题，而且提高了效率 <br/>
 * 总结 <br/>
 * 读写互斥，写读互斥，写写互斥，读读异步！！！！
 * 
 * @author he.gang33
 * @CreateDate 2020/8/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_2_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_2_2.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyService service = new MyService();
        Runnable runnable = () -> service.read();
        Thread ta = new Thread(runnable);
        ta.start();
        Thread tb = new Thread(runnable);
        tb.start();
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        /**
         * username
         */
        private String username = "abc";

        /**
         * read
         */
        public void read() {
            lock.readLock().lock();
            try {
                logger.info("begin...");
                logger.info("read username[{}]", username);
                Thread.sleep(3000);
                logger.info("end...");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.readLock().unlock();
            }
        }
    }

}
