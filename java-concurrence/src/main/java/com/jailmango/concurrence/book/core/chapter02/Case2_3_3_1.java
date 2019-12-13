package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_3_1 - 2.3.3 - 1. 实现代码重排序的测试
 *
 * @author he.gang33
 * @CreateDate 2019-05-31
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_3_3_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_3_1.class);

    private static long x = 0;

    private static long y = 0;

    private static long a = 0;

    private static long b = 0;

    private static long c = 0;

    private static long d = 0;

    private static long e = 0;

    private static long f = 0;

    private static long count = 0;

    public static void main(String[] args) throws InterruptedException {
        for (;;) {
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            c = 0;
            d = 0;
            e = 0;
            f = 0;
            count++;

            Thread thread1 = new Thread(() -> {
                a = 1;
                c = 101;
                d = 102;
                x = b;
            });

            Thread thread2 = new Thread(() -> {
                b = 1;
                e = 201;
                f = 202;
                y = a;
            });

            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();

            if (x == 0 && y == 0) {
                // 有可能会出现该种情况
                // 若出现该种情况，则意味着出现了代码重排序

                /*
                 * 重排序的结果: x = b; a = 1; c = 101; d = 102; 和 y = a; b = 1; e = 201; f = 202;
                 */
                logger.info("Thread[{}] Count[{}] - X[{}] Y[{}]", Thread.currentThread().getName(), count, x, y);
                break;
            }
        }
    }
}
