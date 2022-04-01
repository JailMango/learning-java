package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_1_3 - 2.3.1 - 3. 使用多线程可能出现死循环
 *
 * @author jailmango
 * @CreateDate 2019-05-30
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case2_3_1_3 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_1_3.class);

    // todo 需要找资料理解 https://blog.csdn.net/weixin_38289196/article/details/79537781

    public static void main(String[] args) throws InterruptedException {
        // todo 重要！需要查看kindle上的注释。弄清楚公共堆栈和线程的私有堆栈。。。
        Service service = new Service();
        service.start();
        Thread.sleep(1000);
        // 本例无法通过标记位结束死循环。
        // 原理解析，见kindle 图2-74
        // 线程获取的isFinished的值是取自工作内存(线程的私有堆栈)，之后的更新操作，更新的是主内存(公共堆栈)中的值。因此线程运行时获取的一直是工作内存中的值，因此无法结束死循环。

        service.setFinished(true);
        logger.info("stop...");
    }

    static class Service extends Thread {

        private boolean isFinished = false;

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
