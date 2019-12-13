package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_2_3 - [1.2.3章节 - 实例变量与线程安全]
 *
 * @author he.gang33
 * @CreateDate 2018/11/16
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class Case1_2_3 {

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        InstanceVariableThread insThread = new InstanceVariableThread();
        Thread thread1 = new Thread(insThread, "Ins-1");
        Thread thread2 = new Thread(insThread, "Ins-2");
        Thread thread3 = new Thread(insThread, "Ins-3");
        Thread thread4 = new Thread(insThread, "Ins-4");
        Thread thread5 = new Thread(insThread, "Ins-5");
        Thread thread6 = new Thread(insThread, "Ins-6");

        // UnInstanceVariableThread unThread = new UnInstanceVariableThread();
        // Thread thread1 = new Thread(unThread, "Un-1");
        // Thread thread2 = new Thread(unThread, "Un-2");
        // Thread thread3 = new Thread(unThread, "Un-3");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
    }
}

/**
 * 实例变量线程
 */
class InstanceVariableThread implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(InstanceVariableThread.class);

    /**
     * 计数器
     */
    private int count = 5;

    @Override
    public synchronized void run() {
        logger.info("由[" + Thread.currentThread().getName() + "]计算 count = " + count--);
    }
}

class UnInstanceVariableThread implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(UnInstanceVariableThread.class);

    /**
     * count
     */
    private int count = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            logger.info("由[" + Thread.currentThread().getName() + "]计算 count = " + count++);
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
