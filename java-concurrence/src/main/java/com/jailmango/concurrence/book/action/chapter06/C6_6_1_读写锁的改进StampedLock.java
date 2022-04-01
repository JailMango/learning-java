package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.locks.StampedLock;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_6_1_读写锁的改进StampedLock
 *
 * @author jailmango
 * @CreateDate 2020/11/11
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_6_1_读写锁的改进StampedLock {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }

    private static class Point {
        private double x, y;

        private final StampedLock stampedLock = new StampedLock();

        void move(double deltaX, double deltaY) {
            long stamp = stampedLock.writeLock();

            try {
                x += deltaX;
                y += deltaY;
            }
            finally {
                stampedLock.unlockWrite(stamp);
            }
        }

        double distanceFromOrigin() {
            long stamp = stampedLock.tryOptimisticRead();
            double currentX = x, currentY = y;
            if (!stampedLock.validate(stamp)) {
                stamp = stampedLock.readLock();

                try {
                    currentX = x;
                    currentY = y;
                }
                finally {
                    stampedLock.unlockRead(stamp);
                }
            }

            return Math.sqrt(currentX * currentX + currentY * currentY);
        }

    }
}
