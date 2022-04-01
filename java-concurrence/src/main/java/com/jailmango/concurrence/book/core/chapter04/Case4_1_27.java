package com.jailmango.concurrence.book.core.chapter04;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 4.1.27 实现线程按顺序执行
 *
 * @author jailmango
 * @CreateDate 2020/8/13
 * @see com.jailmango.concurrence.book.core.chapter04
 * @since R9.0
 */
public class Case4_1_27 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case4_1_27.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MyService service = new MyService();
        Runnable ra = () -> service.serviceA();
        Runnable rb = () -> service.serviceB();
        Runnable rc = () -> service.serviceC();

        for (int i = 0; i < 5; i++) {
            Thread ta = new Thread(ra);
            Thread tb = new Thread(rb);
            Thread tc = new Thread(rc);
            ta.start();
            tb.start();
            tc.start();
        }
    }

    private static class MyService {

        private ReentrantLock lock = new ReentrantLock();

        private Condition condition = lock.newCondition();

        private int index = 1;

        public void serviceA() {
            lock.lock();
            try {
                while (index != 1) {
                    condition.await();
                }

                System.out.println("AAA");
                index = 2;
                condition.signalAll();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void serviceB() {
            lock.lock();
            try {
                while (index != 2) {
                    condition.await();
                }

                System.out.println("   BBB");
                index = 3;
                condition.signalAll();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }
        }

        public void serviceC() {
            lock.lock();
            try {
                while (index != 3) {
                    condition.await();
                }

                System.out.println("      CCC");
                index = 1;
                condition.signalAll();
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
