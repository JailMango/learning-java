package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_9 - 3.1.9 wait()方法，立即释放锁
 *
 * @author he.gang33
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_9 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_9.class);

    public static void main(String[] args) {
        Service service = new Service();
        Object lock = new Object();

        Thread a = new Thread(() -> service.doService(lock));
        Thread b = new Thread(() -> service.doService(lock));

        a.start();
        b.start();
        // 执行wait()方法后，立即释放锁。
    }

    static class Service {

        public void doService(Object lock) {
            try {
                synchronized (lock) {
                    logger.info("Thread[{}] begin wait... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    lock.wait();
                    logger.info("Thread[{}] end wait... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
