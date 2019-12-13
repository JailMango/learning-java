package com.jailmango.concurrence.book.core.chapter02;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_10 - 2.2.10 方法是被随机调用的
 *
 * @author he.gang33
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_10 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_10.class);

    public static void main(String[] args) {
        MyList list = new MyList();
        MyThread1 a = new MyThread1("Thread-A", list);
        MyThread2 b = new MyThread2("Thread-B", list);

        // 实验结果较小概率出现线程A与线程B交替运行，但是会出现。
        // 说明方法调用是随机的，即线程A月线程B的执行是异步的。但是begin-end成对出现，说明方法内部是同步的。
        a.start();
        b.start();
    }

    static class MyThread1 extends Thread {

        /**
         * MyList
         */
        private MyList list;

        /**
         * Constructor
         * 
         * @param name String
         * @param list MyList
         */
        public MyThread1(String name, MyList list) {
            super(name);
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                list.add(String.valueOf(i));
            }
        }
    }

    static class MyThread2 extends Thread {

        /**
         * MyList
         */
        private MyList list;

        /**
         * Constructor
         * 
         * @param name String
         * @param list MyList
         */
        public MyThread2(String name, MyList list) {
            super(name);
            this.list = list;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                list.add(String.valueOf(i));
            }
        }
    }

    static class MyList {

        private List<String> list = new ArrayList<>();

        public synchronized void add(String element) {
            logger.info("Thread[{}] add begin...", Thread.currentThread().getName());
            try {
                Thread.sleep(30);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
            list.add(element);
            logger.info("Thread[{}] add {}...", Thread.currentThread().getName(), element);
            logger.info("Thread[{}] add end...", Thread.currentThread().getName());
        }

        public synchronized void getSize() {
            logger.info("Thread[{}] get size begin...", Thread.currentThread().getName());
            try {
                Thread.sleep(30);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
            logger.info("Thread[{}] get size {}...", Thread.currentThread().getName(), list.size());
            logger.info("Thread[{}] get size end...", Thread.currentThread().getName());
        }
    }
}
