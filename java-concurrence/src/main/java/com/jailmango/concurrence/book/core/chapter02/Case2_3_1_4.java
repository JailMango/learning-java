package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_1_4 - 2.3.1 - 4. 使用volatile关键字解决多线程出现的死循环，解决2.3.1.3的问题
 *
 * @author he.gang33
 * @CreateDate 2019-05-30
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_3_1_4 {
    
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_1_4.class);

    public static void main(String[] args) throws InterruptedException {
        // todo 重要！需要查看kindle上的注释。弄清楚公共堆栈和线程的私有堆栈。。。
        Service service = new Service();
        service.start();
        Thread.sleep(1000);
        // 可以通过标记位结束死循环，使用volatile关键字，可以增加示例变量在多个线程之间的可见性
        // 原理解析看kindle 图2-76！！！
        // 不再读写工作内存(线程的私有堆栈)，而是读写主内存(公共堆栈)
        service.setFinished(true);
        logger.info("stop...");
    }

    static class Service extends Thread {

        private volatile boolean isFinished = false;

        @Override
        public void run() {
            logger.info("Thread[{}] into run...", Thread.currentThread().getName());

            while (!isFinished) {

            }

            logger.info("Thread[{}] exit run...", Thread.currentThread().getName());
        }

        public boolean isFinished() {
            return isFinished;
        }

        public void setFinished(boolean finished) {
            isFinished = finished;
        }
    }
}
