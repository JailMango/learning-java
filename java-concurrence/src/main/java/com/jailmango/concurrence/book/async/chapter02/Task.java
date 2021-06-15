package com.jailmango.concurrence.book.async.chapter02;

import lombok.extern.slf4j.Slf4j;

/**
 * Task
 *
 * @author gang.he2
 * @see com.jailmango.concurrence.book.async.chapter02
 */
@Slf4j
public class Task {

    /**
     * task-a
     */
    public static void doTaskA() {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("finish task-a...");
    }

    /**
     * task-b
     */
    public static void doTaskB() {
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("finish task-b...");
    }
}
