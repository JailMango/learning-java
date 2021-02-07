package com.jailmango.concurrence.book.action.chapter03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

/**
 * 高效读写队列ConcurrentLinkedQueue_3_3_4
 *
 * @author he.gang33
 * @CreateDate 2020/10/9
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_3_4_高效读写队列ConcurrentLinkedQueue {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.poll();
        queue.offer("1");
        queue.poll();
//        queue.offer("2");
//        queue.offer("3");

        log.info("end...");
        
        
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Collections.sort(new ArrayList<String>());
    }

}
