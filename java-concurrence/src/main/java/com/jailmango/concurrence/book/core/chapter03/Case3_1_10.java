package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_10 - 3.1.10 sleep()方法，不释放锁
 *
 * @author jailmango
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_10 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_10.class);

    public static void main(String[] args) {
        Object lock = new Object();
        Service service = new Service();

        Thread a = new Thread(() -> service.doService(lock));
        Thread b = new Thread(() -> service.doService(lock));

        a.start();
        b.start();
        // 执行sleep()方法不释放锁，因此是同步效果。
    }

    static class Service {

        public void doService(Object lock) {
            try {
                synchronized (lock) {
                    logger.info("Thread[{}] begin wait... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    Thread.sleep(3000);
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
