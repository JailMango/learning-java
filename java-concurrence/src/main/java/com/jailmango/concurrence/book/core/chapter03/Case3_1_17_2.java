package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_17_2
 *
 * @author he.gang33
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_17_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_17_2.class);

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Service service = new Service();

        Thread b = new Thread(() -> service.notifyMethod(lock));
        b.start();

        Thread.sleep(100);

        Thread a = new Thread(() -> service.waitMethod(lock));
        a.start();

        // 若先执行notify()通知，则不执行wait()
    }

    static class Service {

        private boolean isFirstRunB = false;

        public void waitMethod(Object lock) {
            try {
                synchronized (lock) {
                    logger.info("Thread[{}] before wait...", Thread.currentThread().getName());
                    while (!isFirstRunB) {
                        logger.info("Thread[{}] wait begin... Time[{}]", Thread.currentThread().getName(),
                            System.currentTimeMillis());
                        lock.wait();
                        logger.info("Thread[{}] wait end... Time[{}]", Thread.currentThread().getName(),
                            System.currentTimeMillis());
                    }
                    logger.info("Thread[{}] after wait...", Thread.currentThread().getName());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }

        public void notifyMethod(Object lock) {
            synchronized (lock) {
                logger.info("Thread[{}] notify begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                lock.notify();
                logger.info("Thread[{}] notify end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                isFirstRunB = true;
            }
        }
    }
}
