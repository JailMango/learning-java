package com.jailmango.concurrence.book.core.chapter06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 6.2 延迟加载/懒汉模式 <br/>
 * 指的是调用get()方法实例才被工厂创建，常见的实现办法是在get()方法中进行new实例化 <br/>
 * 本例验证了这种写法的错误性.
 * 
 * @author jailmango
 * @CreateDate 2020/8/18
 * @see com.jailmango.concurrence.book.core.chapter06
 * @since R9.0
 */
public class Case6_2_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case6_2_1.class);

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

        /**
         * instance
         */
        private static MyObject instance;

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
            if (null == instance) {
                instance = new MyObject();
            }

            return instance;
        }

    }

}
