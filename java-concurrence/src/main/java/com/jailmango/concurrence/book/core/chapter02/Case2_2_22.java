package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_22
 *
 * @author he.gang33
 * @CreateDate 2019-05-29
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_22 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_22.class);

    public static void main(String[] args) throws InterruptedException {
        OuterClass.InnerClass1 class1 = new OuterClass.InnerClass1();
        OuterClass.InnerClass2 class2 = new OuterClass.InnerClass2();

        Thread a = new Thread(() -> class1.method1(class2));
        Thread b = new Thread(class1::method2);
        Thread c = new Thread(class2::method1);

        a.start();
        Thread.sleep(100);
        b.start();
        Thread.sleep(100);
        c.start();

        // 线程B与[线程A和线程C]是异步的。因为不是同一把锁。
        // 线程A与线程C是同步的。是同一把锁。锁对象为InnerClass2实例对象
    }

    static class OuterClass {

        static class InnerClass1 {

            public void method1(InnerClass2 object) {
                synchronized (object) {
                    logger.info("Thread[{}] inner-class1 method1 begin... Time[{}]", Thread.currentThread(),
                        System.currentTimeMillis());

                    try {
                        Thread.sleep(5000);
                    }
                    catch (InterruptedException e) {
                        logger.error(e.getLocalizedMessage());
                    }

                    logger.info("Thread[{}] inner-class1 method1 end... Time[{}]", Thread.currentThread(),
                        System.currentTimeMillis());
                }
            }

            public synchronized void method2() {
                for (int i = 0; i < 10; i++) {
                    logger.info("Thread[{}] inner-class1 method2 begin... Time[{}]", Thread.currentThread(),
                        System.currentTimeMillis());

                    try {
                        Thread.sleep(500);
                    }
                    catch (InterruptedException e) {
                        logger.error(e.getLocalizedMessage());
                    }

                    logger.info("Thread[{}] inner-class1 method2 end... Time[{}]", Thread.currentThread(),
                        System.currentTimeMillis());
                }
            }
        }

        static class InnerClass2 {

            public synchronized void method1() {
                logger.info("Thread[{}] inner-class2 method1 begin... Time[{}]", Thread.currentThread(),
                    System.currentTimeMillis());

                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    logger.error(e.getLocalizedMessage());
                }

                logger.info("Thread[{}] inner-class2 method1 end... Time[{}]", Thread.currentThread(),
                    System.currentTimeMillis());
            }
        }
    }
}
