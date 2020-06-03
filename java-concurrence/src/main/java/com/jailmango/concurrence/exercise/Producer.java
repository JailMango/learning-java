package com.jailmango.concurrence.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Producer
 *
 * @author he.gang33
 * @CreateDate 2020/4/27
 * @see com.jailmango.concurrence.exercise
 * @since R9.0
 */
public class Producer implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    /**
     * SharedData
     */
    private SharedData data;

    public Producer(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        Integer count = 0;

        while (true) {
            try {
                logger.info("Produce [{}]", count);
                data.put(count.toString());
                Thread.sleep(3000);
                logger.info("Consume [{}]", data.take());
                count++;
            }
            catch (InterruptedException e) {
                logger.error("Catch InterruptedException...");
                e.printStackTrace();
            }
        }
    }
}
