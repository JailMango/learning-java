package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_11_5 - 1.11.5 使用stop()停止线程
 *
 * @author jailmango
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_11_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_11_5.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.start();
        Thread.sleep(3000);
        // 废弃方法，不建议使用，stop()方法容易造成业务不确定性(清理工作无法完成或者数据添加不完整)，因为其可以在任意时刻强行终止线程
        thread.stop();
    }

    static class MyThread implements Runnable {

        @Override
        public void run() {
            int count = 0;

            while (true) {
                logger.info("Count: [{}]", ++count);
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    logger.info(e.getLocalizedMessage());
                }
            }
        }
    }

}
