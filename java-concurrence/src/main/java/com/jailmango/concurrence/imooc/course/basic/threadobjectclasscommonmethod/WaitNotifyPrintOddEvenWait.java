package com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WaitNotifyPrintOddEvenWait <br/>
 * 用两个线程交替打印0~100的奇偶数，用wait/notify实现 <br/>
 * 本例不会出现synchronized中的废操作
 *
 * @author he.gang33
 * @CreateDate 2020/5/2
 * @see com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod
 * @since R9.0
 */
public class WaitNotifyPrintOddEvenWait {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WaitNotifyPrintOddEvenWait.class);

    private static int count = 0;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new TurningRunnable(), "偶数线程");
        thread1.start();
        Thread thread2 = new Thread(new TurningRunnable(), "奇数线程");
        thread2.start();
    }

    private static class TurningRunnable implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    logger.info("{} -> {},", Thread.currentThread().getName(), count++);
                    lock.notify();

                    if (count <= 100) {
                        try {
                            lock.wait();
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

}
