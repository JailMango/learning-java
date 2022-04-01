package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.26 public void awaitUninterruptibly()方法的使用 <br/>
 * 作用是实现在线程等待过程中，不允许被中断
 *
 * @author jailmango
 * @CreateDate 2020/8/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_26 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_26.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try {
            MyServcie servcie = new MyServcie();
            Runnable runnable = () -> servcie.awaitUninterruptiblyService();
            Thread ta = new Thread(runnable);
            ta.start();
            Thread.sleep(2000);
            ta.interrupt();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyServcie {

        private ReentrantLock lock = new ReentrantLock();

        private Condition condition = lock.newCondition();

        public void awaitUninterruptiblyService() {
            lock.lock();
            try {
                logger.info("awaitUninterruptibly begin...");
                condition.awaitUninterruptibly();
                logger.info("awaitUninterruptibly end...");
            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            finally {
                lock.unlock();
            }
        }
    }

}
