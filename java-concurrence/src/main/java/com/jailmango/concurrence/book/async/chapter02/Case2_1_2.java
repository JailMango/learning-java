package com.jailmango.concurrence.book.async.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * 2.1 显式使用线程实现异步编程 <br/>
 * 异步执行
 *
 * @author gang.he2
 * @see com.jailmango.concurrence.book.async.chapter02
 */
@Slf4j
public class Case2_1_2 {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Thread thread = new Thread(Task::doTaskA);
        thread.start();

        Task.doTaskB();

        long end = System.currentTimeMillis();

        log.info("Cost -> {}ms", end - start);
    }
}
