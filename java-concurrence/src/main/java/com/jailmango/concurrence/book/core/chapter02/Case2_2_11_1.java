package com.jailmango.concurrence.book.core.chapter02;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_11 - 不同步(即线程不安全)导致出现的错误 - 修复模拟错误的示例
 *
 * @author jailmango
 * @CreateDate 2019-05-24
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_11_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_11_1.class);

    public static void main(String[] args) throws InterruptedException {
        OneSizeList list = new OneSizeList();
        MyThread1 a = new MyThread1("Thread-A", list);
        MyThread2 b = new MyThread2("Thread-B", list);

        a.start();
        Thread.sleep(200);
        b.start();

        // 该实验输出list大小为1，符合要求。
        // 因为OneSizeList在本示例只存在一个实例，是单例的。同时需求需要对list.getSize()操作进行同步调用。因此对list进行加锁即可。
        Thread.sleep(5000);
        logger.info("Size: [{}]", list.getSize());
    }

    static class MyThread1 extends Thread {

        /**
         * OneSizeList
         */
        private OneSizeList list;

        /**
         * Constructor
         * 
         * @param name String
         * @param list OneSizeList
         */
        public MyThread1(String name, OneSizeList list) {
            super(name);
            this.list = list;
        }

        @Override
        public void run() {
            new Service().addService(list, "a");
        }
    }

    static class MyThread2 extends Thread {

        /**
         * OneSizeList
         */
        private OneSizeList list;

        /**
         * Constructor
         *
         * @param name String
         * @param list OneSizeList
         */
        public MyThread2(String name, OneSizeList list) {
            super(name);
            this.list = list;
        }

        @Override
        public void run() {
            new Service().addService(list, "b");
        }
    }

    static class Service {

        public OneSizeList addService(OneSizeList list, String element) {
            try {
                synchronized (list) {
                    if (list.getSize() < 1) {
                        Thread.sleep(3000);
                        list.add(element);
                        logger.info("Thread[{}] add {}", Thread.currentThread().getName(), element);
                    }
                }
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }

            return list;
        }
    }

    static class OneSizeList {

        /**
         * list
         */
        private List<String> list = new ArrayList<>();

        /**
         * add
         * 
         * @param element String
         */
        public synchronized void add(String element) {
            list.add(element);
        }

        /**
         * getSize
         * 
         * @return int
         */
        public synchronized int getSize() {
            return list.size();
        }
    }
}
