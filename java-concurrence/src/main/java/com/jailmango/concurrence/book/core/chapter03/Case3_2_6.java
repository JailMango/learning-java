package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_2_6 - 3.2.6 join()方法后面的代码提前运行 - 解释意外
 *
 * @author he.gang33
 * @CreateDate 2019/12/19
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_2_6 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_2_6.class);

    public static void main(String[] args) {
        logger.info("Main[{}] begin... Time[{}]", Thread.currentThread().getName(), System.currentTimeMillis());
        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);

        a.start();
        b.start();
        logger.info("Main[{}] end... Time[{}]", Thread.currentThread().getName(), System.currentTimeMillis());
    }

    private static class ThreadA extends Thread {

        private ThreadB b;

        public ThreadA(ThreadB b) {
            super();
            this.b = b;
        }

        @Override
        public void run() {
            try {
                synchronized (b) {
                    logger.info("ThreadA[{}] begin... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                    Thread.sleep(1000);
                    logger.info("ThreadA[{}] end... Time[{}]", Thread.currentThread().getName(),
                        System.currentTimeMillis());
                }
            }
            catch (InterruptedException e) {
                logger.error("ThreadA捕获InterruptedException异常...");
                e.printStackTrace();
            }
        }
    }

    private static class ThreadB extends Thread {

        @Override
        public synchronized void run() {
            try {
                logger.info("ThreadB[{}] begin... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
                Thread.sleep(1000);
                logger.info("ThreadB[{}] end... Time[{}]", Thread.currentThread().getName(),
                    System.currentTimeMillis());
            }
            catch (InterruptedException e) {
                logger.error("ThreadB捕获InterruptedException异常...");
                e.printStackTrace();
            }
        }
    }
}
