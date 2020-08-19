package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.2.5 ReentrantReadWriteLock类的使用 - 写读互斥
 *
 * @author he.gang33
 * @CreateDate 2020/8/17
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_2_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_2_5.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        Runnable writeRunnable = () -> service.write();
        Runnable readRunnable = () -> service.read();

        Thread wt = new Thread(writeRunnable);
        wt.start();

        Thread.sleep(1000);

        Thread rt = new Thread(readRunnable);
        rt.start();
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
                Thread.sleep(4000);
                logger.info("释放写锁...");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.writeLock().unlock();
            }
        }

        /**
         * read
         */
        public void read() {
            lock.readLock().lock();
            try {
                logger.info("获得读锁...");
                Thread.sleep(4000);
                logger.info("释放读锁...");
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
