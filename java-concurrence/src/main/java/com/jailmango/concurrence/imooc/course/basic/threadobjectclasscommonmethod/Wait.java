package com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Wait <br/>
 * 展示wait()和notify()基本用法 <br/>
 * 1. 研究代码执行顺序 <br/>
 * 2. 证明wait()是释放锁的 <br/>
 * 
 * @author he.gang33
 * @CreateDate 2020/5/2
 * @see com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod
 * @since R9.0
 */
public class Wait {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Wait.class);

    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread1 th1 = new Thread1();
        Thread2 th2 = new Thread2();
        th1.start();
        Thread.sleep(100);
        th2.start();
    }

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                logger.info("Thread1 is running...");
                try {
                    object.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info("Thread1 get lock...");
            }
        }
    }

    private static class Thread2 extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                logger.info("Thread2 is running...");
                object.notify();
                logger.info("Thread2 notify...");
            }
        }
    }
}
