package com.jailmango.concurrence.book.core.chapter04;

import java.util.Calendar;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.25 public boolean awaitUntil(Date deadline)方法的使用 <br/>
 * 作用是在指定的时间结束等待
 *
 * @author he.gang33
 * @CreateDate 2020/8/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_25 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_25.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyService service = new MyService();
        Runnable runnable = () -> service.waitService();
        Runnable runnable1 = () -> service.notifyService();
        Thread ta = new Thread(runnable);
        ta.start();
        Thread tb = new Thread(runnable1);
        tb.start();
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * condition
         */
        private Condition condition = lock.newCondition();

        public void waitService() {
            Calendar now = Calendar.getInstance();
            now.add(Calendar.SECOND, 5);

            lock.lock();
            try {
                logger.info("await begin...");
                condition.awaitUntil(now.getTime());
                logger.info("await end...");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void notifyService() {
            Calendar now = Calendar.getInstance();
            now.add(Calendar.SECOND, 5);

            lock.lock();
            try {
                logger.info("notify begin...");
                Thread.sleep(1000);
                condition.signalAll();
                logger.info("notify end...");
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
