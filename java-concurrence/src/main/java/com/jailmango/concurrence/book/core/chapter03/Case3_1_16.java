package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_16 - 3.1.16 wait(long)方法自动向下运行需要重新持有锁
 *
 * @author jailmango
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_16 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_16.class);

    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        Object lock = new Object();

        Thread a = new Thread(() -> service.waitMethod(lock));
        Thread b = new Thread(() -> service.longTimeMethod(lock));

        a.start();
        Thread.sleep(100);
        b.start();

        // wait(long)方法若想自动向下运行，需要持有锁。如果没锁，则处于等待，直到持有锁为止。
    }

    static class Service {

        public void waitMethod(Object lock) {
            try {
                synchronized (lock) {
                    logger.info("Thread[{}] wait begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    lock.wait(2000);
                    logger.info("Thread[{}] wait end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public void longTimeMethod(Object lock) {
            synchronized (lock) {
                try {
                    logger.info("Thread[{}] do long-time task begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    Thread.sleep(8000);
                    logger.info("Thread[{}] do long-time task end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
                catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage());
                }
            }
        }
    }
}
