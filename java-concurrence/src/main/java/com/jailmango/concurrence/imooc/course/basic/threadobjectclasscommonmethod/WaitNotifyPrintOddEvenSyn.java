package com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WaitNotifyPrintOddEvenSyn <br/>
 * 用两个线程交替打印0~100的奇偶数，用synchronized关键字实现 <br/>
 * 本例实现方式不好，会有很多无用的循环判断
 * 
 * @author he.gang33
 * @CreateDate 2020/5/2
 * @see com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod
 * @since R9.0
 */
public class WaitNotifyPrintOddEvenSyn {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(WaitNotifyPrintOddEvenSyn.class);

    private static int count = 0;

    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    // 重要！！！
                    // & 位与运算
                    // 和1做位与运算，实际上是取出最低位，如果是0就是偶数，如果是1就是基数
                    if ((count & 1) == 0) {
                        logger.info("{} -> 偶数[{}],", Thread.currentThread().getName(), count++);
                    }
                }
            }
        }, "偶数").start();

        new Thread(() -> {
            while (count <= 100) {
                synchronized (lock) {
                    if ((count & 1) == 1) {
                        logger.info("{} -> 奇数[{}],", Thread.currentThread().getName(), count++);
                    }
                }
            }
        }, "奇数").start();
    }
}
