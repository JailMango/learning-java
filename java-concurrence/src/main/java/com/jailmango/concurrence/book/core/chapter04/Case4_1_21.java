package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.21 - public boolean tryLock()方法的使用 <br/>
 * 作用是嗅探拿锁，如果当前线程发现锁被其他线程持有了，则返回false，执行后面的代码 <br/>
 * 而不是呈阻塞等待锁的状态。
 *
 * @author jailmango
 * @CreateDate 2020/8/12
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_21 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_21.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        Runnable runnable = () -> service.doService();

        Thread ta = new Thread(runnable);
        ta.start();
        Thread.sleep(50);
        Thread tb = new Thread(runnable);
        tb.start();
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

            try {
                if (lock.tryLock()) {
                    logger.info("[{}]获得锁...", Thread.currentThread().getName());
                    Thread.sleep(2000);
                }
                else {
                    logger.info("[{}]没有获得锁...", Thread.currentThread().getName());
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                    logger.info("[{}]释放锁...", Thread.currentThread().getName());
                }
            }
        }
    }
}
