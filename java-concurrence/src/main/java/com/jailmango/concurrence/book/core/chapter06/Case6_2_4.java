package com.jailmango.concurrence.book.core.chapter06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 6.2.4 使用DCL机制(Double-Check Locking，双检查锁)
 *
 * @author jailmango
 * @CreateDate 2020/8/24
 * @see com.jailmango.concurrence.book.core.chapter06
 * @since R9.0
 */
public class Case6_2_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case6_2_4.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Runnable runnable = () -> logger.info("MyObject[{}]", MyObject.getInstance().hashCode());
        for (int i = 0; i < 200; i++) {
            Thread a = new Thread(runnable);
            Thread b = new Thread(runnable);
            Thread c = new Thread(runnable);
            a.start();
            b.start();
            c.start();
        }
    }

    private static class MyObject {

        private volatile static MyObject instance;

        private MyObject() {

        }

        public static MyObject getInstance() {
            try {
                if (null == instance) {
                    Thread.sleep(3000);
                    synchronized (MyObject.class) {
                        if (null == instance) {
                            instance = new MyObject();
                        }
                    }
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            return instance;
        }
    }
}
