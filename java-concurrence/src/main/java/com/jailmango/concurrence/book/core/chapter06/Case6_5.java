package com.jailmango.concurrence.book.core.chapter06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 6.5 使用static代码块实现单例模式
 *
 * @author he.gang33
 * @CreateDate 2020/8/31
 * @see com.jailmango.concurrence.book.core.chapter06
 * @since R9.0
 */
public class Case6_5 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case6_5.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Runnable runnable = () -> {
            logger.info("MyObject HashCode: [{}]", MyObject.getInstance().hashCode());
        };

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    private static class MyObject {

        private static MyObject instance;

        private MyObject() {

        }

        static {
            instance = new MyObject();
        }

        public static MyObject getInstance() {
            return instance;
        }
    }

}
