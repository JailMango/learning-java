package com.jailmango.concurrence.book.action.chapter04;

import java.util.concurrent.LinkedBlockingQueue;

import lombok.extern.slf4j.Slf4j;

/**
 * 锁分离_4_1_4
 *
 * @author jailmango
 * @CreateDate 2020/10/9
 * @see com.jailmango.concurrence.book.action.chapter04
 * @since R9.0
 */
@Slf4j
public class 锁分离_4_1_4 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();

        queue.put("1");
        queue.put("2");
        queue.put("3");
        queue.put("4");
        queue.put("5");

        log.info("{}", queue.peek());
        log.info("{}", queue.poll());
        log.info("{}", queue.take());
        log.info("{}", queue.take());
        log.info("{}", queue.take());
        log.info("{}", queue.take());
    }
}
