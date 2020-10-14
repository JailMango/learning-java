package com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WaitNotifyReleaseOwnMonitor <br/>
 * 证明wait()只释放当前的那把锁
 * 
 * @author he.gang33
 * @CreateDate 2020/5/2
 * @see com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod
 * @since R9.0
 */
public class WaitNotifyReleaseOwnMonitor {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WaitNotifyReleaseOwnMonitor.class);

    private static volatile Object resourceA = new Object();

    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            synchronized (resourceA) {
                logger.info("{} got resource-A...", Thread.currentThread().getName());

                synchronized (resourceB) {
                    logger.info("{} got resource-B...", Thread.currentThread().getName());

                    try {
                        logger.info("{} release resource-A...", Thread.currentThread().getName());
                        resourceA.wait();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (resourceA) {
                logger.info("{} got resource-A...", Thread.currentThread().getName());

                logger.info("try...");
                synchronized (resourceB) {
                    logger.info("{} got resource-B...", Thread.currentThread().getName());
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
