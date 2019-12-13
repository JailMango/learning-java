package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_12_2_1 - 1.12.2 suspend()和resume()方法缺点:独占
 *
 * @author he.gang33
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_12_2_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_12_2_1.class);

    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject obj = new SynchronizedObject();

        Thread threadA = new Thread("Thread-A") {
            @Override
            public void run() {
                logger.info("Thread-A running...");
                obj.doService();
                logger.info("Thread-A end...");
            }
        };
        threadA.start();
        Thread.sleep(300);

        // 由于doService()被线程A锁定，且线程A一直suspend，因此线程B无法进入doService()
        Thread threadB = new Thread("Thread-B") {
            @Override
            public void run() {
                logger.info("Thread-B running...");
                obj.doService();
                logger.info("Thread-B end...");
            }
        };
        threadB.start();

        // 由于线程A恢复，并且执行完了doService，释放了公共同步对象，因此线程B可以进入doService()，并执行完成
        Thread.sleep(5000);
        threadA.resume();
    }

    static class SynchronizedObject {

        public synchronized void doService() {
            logger.info("{} do service begin...", Thread.currentThread().getName());

            if ("Thread-A".equals(Thread.currentThread().getName())) {
                logger.info("Thread-A suspend...");
                Thread.currentThread().suspend();
            }

            logger.info("{} do service end...", Thread.currentThread().getName());
        }
    }

}
