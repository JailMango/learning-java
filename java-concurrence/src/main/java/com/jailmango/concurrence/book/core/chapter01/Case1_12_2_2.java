package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_12_2_2 - 1.12.2 suspend()和resume()方法缺点:独占
 *
 * @author jailmango
 * @CreateDate 2019-05-22
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_12_2_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_12_2_2.class);

    public static void main(String[] args) throws InterruptedException {

    }

    /**
     * 由于MyThread线程只是被暂停，并未被停止，因此即使主线程main退出，看到「main end...」后程序依旧在运行。若将suspend()改为stop()，看到「main end...」后程序依会停止。
     * 
     * @throws InterruptedException InterruptedException
     */
    private static void runMyThread() throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(2000);
        thread.suspend();
        logger.info("main end...");
    }

    /**
     * 该示例看不到输出「main end...」。原因是因为当程序运行到System.out.println()方法内部停止时，
     * 同步锁是不释放的。System.out.println()方法内部带有synchronized。
     * 当前PrintStream对象的println()方法一直呈"暂停"状态，并且"锁未释放"。
     * 而main线程中的System.out.println()也需要这把锁，因此不会打印，且main线程也无法停止。
     * @throws InterruptedException InterruptedException
     */
    private static void runAnotherMyThread() throws InterruptedException {
        AnotherMyThread thread = new AnotherMyThread();
        thread.start();
        Thread.sleep(10);
        thread.suspend();
        logger.info("main end...");
    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    static class AnotherMyThread extends Thread {
        @Override
        public void run() {
            int count = 0;
            while (true) {
                System.out.println(++count);
            }
        }
    }

}
