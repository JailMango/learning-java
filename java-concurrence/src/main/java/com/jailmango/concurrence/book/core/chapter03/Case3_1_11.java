package com.jailmango.concurrence.book.core.chapter03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case3_1_11 - 3.1.11 notify()方法，不立即释放锁，见Case3_1_6
 *
 * @author he.gang33
 * @CreateDate 2019-06-03
 * @see com.jailmango.concurrence.book.core.chapter03
 * @since R9.0
 */
public class Case3_1_11 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case3_1_11.class);

    public static void main(String[] args) {

        // 执行notify()方法后，不会立即释放锁。「需要等待notify()方法所在synchronized{}同步代码块执行完后，才会释放锁。」！！！
    }
}
