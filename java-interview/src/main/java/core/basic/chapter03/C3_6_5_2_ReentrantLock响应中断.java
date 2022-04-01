package core.basic.chapter03;

import java.util.concurrent.locks.ReentrantLock;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_6_5_2_ReentrantLock响应中断
 *
 * @author jailmango
 * @CreateDate 2020/11/18
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_6_5_2_ReentrantLock响应中断 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        InterruptiblyLock interruptiblyLock = new InterruptiblyLock();

        Thread t1 = interruptiblyLock.lock1();
        Thread t2 = interruptiblyLock.lock2();

        while (true) {
            if (System.currentTimeMillis() - start >= 10000) {
                t2.interrupt();
            }
        }
    }

    private static class InterruptiblyLock {

        private ReentrantLock lock1 = new ReentrantLock();

        private ReentrantLock lock2 = new ReentrantLock();

        public Thread lock1() {
            Thread thread = new Thread(() -> {
                try {
                    lock1.lockInterruptibly();

                    log.info("工作...");
                    Thread.sleep(2000);

                    lock2.lockInterruptibly();
                    Thread.sleep(2000);

                    log.info("结束...");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    if (lock2.isHeldByCurrentThread()) {
                        lock2.unlock();
                    }

                    if (lock1.isHeldByCurrentThread()) {
                        lock1.unlock();
                    }

                    log.info("退出...");
                }
            });

            thread.start();
            return thread;
        }

        public Thread lock2() {
            Thread thread = new Thread(() -> {
                try {
                    lock2.lockInterruptibly();

                    log.info("工作...");
                    Thread.sleep(2000);

                    lock1.lockInterruptibly();
                    Thread.sleep(2000);

                    log.info("结束...");
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    if (lock1.isHeldByCurrentThread()) {
                        lock1.unlock();
                    }

                    if (lock2.isHeldByCurrentThread()) {
                        lock2.unlock();
                    }

                    log.info("退出...");
                }
            });

            thread.start();
            return thread;
        }
    }
}
