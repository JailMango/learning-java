package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_17_1 - 3.1.17 通知过早的问题与解决办法
 *
 * @author jailmango
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_17_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_17_1.class);

    public static void main(String[] args) {

    }

    /**
     * 示例1 - 没问题的示例，先wait再notify。
     */
    private static void case1() {
        Object lock = new Object();
        Service service = new Service();

        Thread a = new Thread(() -> service.waitMethod(lock));
        a.start();
        Thread b = new Thread(() -> service.notifyMethod(lock));
        b.start();
    }

    /**
     * 示例2 - 有问题的示例，先notify再wait。
     */
    private static void case2() {
        Object lock = new Object();
        Service service = new Service();

        Thread b = new Thread(() -> service.notifyMethod(lock));
        b.start();
        Thread a = new Thread(() -> service.waitMethod(lock));
        a.start();

        // 本例会出现线程A一直处于等待状态，无法唤醒。因为先执行了notify()。
    }

    static class Service {

        public void waitMethod(Object lock) {
            try {
                synchronized (lock) {
                    logger.info("Thread[{}] wait begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    lock.wait();
                    logger.info("Thread[{}] wait end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
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
            }
        }
    }
}
