package com.jailmango.concurrence.book.java高并发核心编程.chapter02;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * C2_9_5_线程间通信_生产者消费者模式
 *
 * @author jailmango
 * @CreateDate 2022/2/2
 * @see com.jailmango.concurrence.book.java高并发核心编程.chapter02
 */
@Slf4j
public class C2_9_5_线程间通信_生产者消费者模式 {

    /**
     * Data buffer max length
     */
    public static final int MAX_COUNT = 10;

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        log.info("hahaha....");
    }

    private static class DataBuffer<T> {

        private List<T> dataList = new LinkedList<>();

        private Integer amount = 0;

        private final Object LOCK_OBJECT = new Object();

    }
}
