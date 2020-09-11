package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.20 public void lockInterruptibly()方法的使用 <br/>
 * 当某个线程尝试获得锁并且阻塞在lockInterruptibly()方法时，该线程可以被中断
 *
 * @author he.gang33
 * @CreateDate 2020/8/12
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_20_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_20_2.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        Runnable runnable = () -> service.doService();
        Thread tha = new Thread(runnable);
        tha.start();
        Thread.sleep(10);

        Thread thb = new Thread(runnable);
        thb.start();
        Thread.sleep(10);

        thb.interrupt();
        logger.info("main中断b，但是没有成功.");
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * doService
         */
        public void doService() {
            String msg;
            try {
                lock.lockInterruptibly();
                logger.info("[{}] begin...", Thread.currentThread().getName());

                for (int i = 0; i < 10000 / 10; i++) {
                    msg = new String();
                    Math.random();
                    Thread.yield();
                    logger.info("[{}] end...", Thread.currentThread().getName());
                }
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
