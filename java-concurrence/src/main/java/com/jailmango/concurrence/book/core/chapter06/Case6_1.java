package com.jailmango.concurrence.book.core.chapter06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 6.1 立即加载/饿汉模式 <br/>
 * 指使用类的时候已经将对象创建完毕，常见的实现办法是直接用new实例化
 *
 * @author he.gang33
 * @CreateDate 2020/8/18
 * @see com.jailmango.concurrence.book.core.chapter06
 * @since R9.0
 */
public class Case6_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case6_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Runnable runnable = () -> logger.info("MyObject[{}]", MyObject.getInstance().hashCode());
        Thread a = new Thread(runnable);
        Thread b = new Thread(runnable);
        Thread c = new Thread(runnable);

        a.start();
        b.start();
        c.start();
    }

    private static class MyObject {

        /**
         * instance
         */
        private static MyObject instance = new MyObject();

        /**
         * Constructor
         */
        private MyObject() {

        }

        /**
         * getInstance
         * 
         * @return MyObject
         */
        public static MyObject getInstance() {
            return instance;
        }
    }

}
