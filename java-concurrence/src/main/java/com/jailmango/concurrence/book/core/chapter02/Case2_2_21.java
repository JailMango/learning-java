package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_21 - 2.2.21 内置类与同步 实验1
 *
 * @author he.gang33
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_21 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_21.class);

    public static void main(String[] args) throws InterruptedException {
        OuterClass.InnerClass innerClass = new OuterClass.InnerClass();

        Thread a = new Thread(() -> innerClass.method1());
        Thread b = new Thread(() -> innerClass.method2());

        a.start();
        Thread.sleep(100);
        b.start();

        // 由于使用的不是同一把锁，因此线程A与线程B并不是同步的
    }

    static class OuterClass {

        static class InnerClass {

            public void method1() {
                synchronized ("other lock") {
                    for (int i = 0; i < 10; i++) {
                        logger.info("Thread[{}] method1() begin", Thread.currentThread().getName());

                        try {
                            Thread.sleep(1000);
                        }
                        catch (InterruptedException e) {
                            logger.error(e.getLocalizedMessage());
                        }

                        logger.info("Thread[{}] method1() doing -> {}", Thread.currentThread().getName(), i);
                        logger.info("Thread[{}] method1() end", Thread.currentThread().getName());
                    }
                }
            }

            public synchronized void method2() {
                for (int i = 0; i < 10; i++) {
                    logger.info("Thread[{}] method2() begin", Thread.currentThread().getName());

                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        logger.error(e.getLocalizedMessage());
                    }

                    logger.info("Thread[{}] method2() doing -> {}", Thread.currentThread().getName(), i);
                    logger.info("Thread[{}] method2() end", Thread.currentThread().getName());
                }
            }
        }
    }
}
