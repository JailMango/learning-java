package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_23
 *
 * @author he.gang33
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_23 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_23.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();

        Thread a = new Thread(service::doService);
        a.setName("Thread-A");

        Thread b = new Thread(service::doService);
        b.setName("Thread-B");

        a.start();
        Thread.sleep(100);
        b.start();

        // 本例中线程A与线程B是异步的。因为锁在运行时被改变了，因此出现了异步的情况，不符合预期。
    }

    static class Service {

        private String lock = "123";

        public void doService() {
            try {
                synchronized (lock) {
                    logger.info("Thread[{}] service begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    lock = "456";
                    Thread.sleep(2000);
                    logger.info("Thread[{}] service end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
