package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.2.1 ReentrantLock类的缺点 <br/>
 * 使用ReentrantLock对象时，所有的操作都同步，哪怕只对实例变量进行读取操作 <br/>
 * 这样会耗费大量的时间，降低运行效率。
 * 
 * @author jailmango
 * @CreateDate 2020/8/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_2_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_2_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyService service = new MyService();
        Runnable runnable = () -> service.read();
        Thread ta = new Thread(runnable);
        ta.start();
        Thread tb = new Thread(runnable);
        tb.start();
    }

    private static class MyService {

        /**
         * lock
         */
        private ReentrantLock lock = new ReentrantLock();

        /**
         * username
         */
        private String username = "abc";

        /**
         * read
         */
        public void read() {
            lock.lock();
            try {
                logger.info("read begin...");
                logger.info("username[{}]", this.username);
                Thread.sleep(2000);
                logger.info("read end...");
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }
    }

}
