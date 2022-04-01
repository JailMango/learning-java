package com.jailmango.concurrence.book.core.chapter06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 6.3 使用静态内部类实现单例
 *
 * @author jailmango
 * @CreateDate 2020/8/31
 * @see com.jailmango.concurrence.book.core.chapter06
 * @since R9.0
 */
public class Case6_3 {
    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case6_3.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Runnable runnable = () -> logger.info("Object HashCode: [{}]", MyObject.getInstance().hashCode());

        Thread th1 = new Thread(runnable);
        Thread th2 = new Thread(runnable);
        Thread th3 = new Thread(runnable);

        th1.start();
        th2.start();
        th3.start();
    }

    private static class MyObject {

        private static class MyObjectHandler {

            /**
             * instance
             */
            private static MyObject instance = new MyObject();
        }

        private MyObject() {

        }

        public static MyObject getInstance() {
            return MyObjectHandler.instance;
        }
    }

}
