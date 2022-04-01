package com.jailmango.concurrence.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Consumer
 *
 * @author jailmango
 * @CreateDate 2020/4/27
 * @see com.jailmango.concurrence.exercise
 * @since R9.0
 */
public class Consumer implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    /**
     * SharedData
     */
    private SharedData data;

    public Consumer(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String obj = data.take();
                logger.info("Consume [{}]", obj);
                Thread.sleep(3000);
                obj += "-Modify";
                data.put(obj);
                logger.info("Producer [{}]", obj);
            }
            catch (InterruptedException e) {
                logger.info("Catch InterruptedException...");
                e.printStackTrace();
            }
        }
    }
}
