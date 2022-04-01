package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_4_7 - 3.4.7 重写childValue()方法实现对继承的值进行加工
 * 通过重写childValue()方法，子线程可以对从父线程继承的值进行加工修改
 * InheritableThreadLocalExt.set()方法 和 重写childValue()方法都可以实现覆盖从父线程继承的值。
 * 那么两者的区别是什么呢？
 * InheritableThreadLocalExt.set()可以在任意时刻执行任意次
 * 重写childValue()方法只有在创建子线程时才会执行且仅执行一次
 * @author jailmango
 * @CreateDate 2019/12/26
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_4_7 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_4_7.class);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            logger.info("Main -> {}", Data.inheritableThreadLocalExt.get());
            Thread.sleep(500);
        }

        ThreadA a = new ThreadA();
        a.start();

    }

    private static class ThreadA extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    logger.info("Thread A -> {}", Data.inheritableThreadLocalExt.get());
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Data {

        /**
         * InheritableThreadLocal
         */
        public static InheritableThreadLocalExt inheritableThreadLocalExt = new InheritableThreadLocalExt();
    }

    private static class InheritableThreadLocalExt extends InheritableThreadLocal {

        @Override
        protected Object initialValue() {
            return "初始化的值...";
        }

        @Override
        protected Object childValue(Object parentValue) {
            return parentValue + " 我是子线程加的~~~";
        }
    }
}
