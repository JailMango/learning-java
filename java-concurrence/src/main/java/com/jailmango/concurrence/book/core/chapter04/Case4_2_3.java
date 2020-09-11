package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ReentrantReadWriteLock类的使用 - 写写互斥 <br/>
 * 使用写锁代码lock.writeLock()的效果是同一时间只允许一个线程执行lock()方法后面的代码 <br/>
 * 
 * @author he.gang33
 * @CreateDate 2020/8/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_2_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_2_3.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyService service = new MyService();
        Runnable runnable = () -> service.write();
        Thread ta = new Thread(runnable);
        Thread tb = new Thread(runnable);
        ta.start();
        tb.start();
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        /**
         * write
         */
        public void write() {
            lock.writeLock().lock();
            try {
                logger.info("获得写锁...");
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.writeLock().unlock();
            }
        }
    }
}
