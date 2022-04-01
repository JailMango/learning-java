package com.jailmango.concurrence.exercise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SharedData
 *
 * @author jailmango
 * @CreateDate 2020/4/27
 * @see com.jailmango.concurrence.exercise
 * @since R9.0
 */
public class SharedData {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SharedData.class);

    /**
     * queue
     */
    private BlockingQueue<String> queue;

    public SharedData() {
        this.queue = new ArrayBlockingQueue<>(1);
    }

    public synchronized String take() throws InterruptedException {
        String obj = this.queue.take();
        logger.info("Queue Size: [{}]", this.queue.size());
        return obj;
    }

    public synchronized void put(String data) throws InterruptedException {
        this.queue.put(data);
        logger.info("Queue Size: [{}]", this.queue.size());
    }

}
