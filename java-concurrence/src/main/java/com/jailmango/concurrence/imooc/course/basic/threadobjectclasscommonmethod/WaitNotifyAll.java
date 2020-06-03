package com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WaitNotifyAll <br/>
 * 本例中有3个线程，线程1和线程2首先被阻塞，线程3使用notify()和notifyAll()唤醒他们 <br/>
 * start()先执行，不代表线程先启动 <br/>
 *
 * @author he.gang33
 * @CreateDate 2020/5/2
 * @see com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod
 * @since R9.0
 */
public class WaitNotifyAll implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WaitNotifyAll.class);

    private static final Object RESOURCE_A = new Object();

    @Override
    public void run() {
        synchronized (RESOURCE_A) {
            logger.info("{} get resource-A...", Thread.currentThread().getName());

            try {
                logger.info("{} release resource-A, and wait for starting...", Thread.currentThread().getName());
                RESOURCE_A.wait();
                logger.info("{} get resource-A again, and waiting for ending...", Thread.currentThread().getName());
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new WaitNotifyAll();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);

        Thread thread3 = new Thread(() -> {
            synchronized (RESOURCE_A) {
                logger.info("{} get resource-A...", Thread.currentThread().getName());
                // RESOURCE_A.notifyAll();
                RESOURCE_A.notify();
                logger.info("{} get resource-A, and notify all...", Thread.currentThread().getName());
            }
        });

        thread1.start();
        thread2.start();

        Thread.sleep(200);
        thread3.start();
    }
}
