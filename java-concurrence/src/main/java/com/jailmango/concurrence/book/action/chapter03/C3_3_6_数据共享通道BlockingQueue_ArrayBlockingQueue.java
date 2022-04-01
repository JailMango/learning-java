package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import lombok.extern.slf4j.Slf4j;

/**
 * 数据共享BlockingQueue_ArrayBlockingQueue_3_3_6
 *
 * @author jailmango
 * @CreateDate 2020/10/20
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_3_6_数据共享通道BlockingQueue_ArrayBlockingQueue {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

        blockingQueue.put("1");
        blockingQueue.put("2");
    }
}
