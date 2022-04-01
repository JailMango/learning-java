package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_6_2_StampedLock的缺点
 *
 * @author jailmango
 * @CreateDate 2020/11/11
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_6_2_StampedLock的缺点 {
    static Thread[] holdCpuThreads = new Thread[3];

    static final StampedLock stampedLock = new StampedLock();

    private static class HoldCPUReadThread implements Runnable {

        @Override
        public void run() {
            long lockr = stampedLock.readLock();
            log.info("获得锁...");
            stampedLock.unlockRead(lockr);
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            long stamp = stampedLock.writeLock();
            LockSupport.parkNanos(60000000000L);
            stampedLock.unlockWrite(stamp);
        }).start();

        Thread.sleep(100);

        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i] = new Thread(new HoldCPUReadThread());
            holdCpuThreads[i].start();
        }

        Thread.sleep(100);

        for (int i = 0; i < 3; i++) {
            holdCpuThreads[i].interrupt();
        }
    }
}
