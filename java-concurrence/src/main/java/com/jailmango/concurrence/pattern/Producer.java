package com.jailmango.concurrence.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Producer
 *
 * @author jailmango
 * @CreateDate 2018/11/21
 * @see com.jailmango.concurrence.pattern
 * @since R9.0<br>
 */
public class Producer implements Runnable {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(Producer.class);

    /**
     * order
     */
    private Order order;

    /**
     * Constructor
     *
     * @param order Order
     */
    public Producer(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        logger.info("Producer[" + Thread.currentThread().getName() + "] starting...");

        int count = 0;

        while (count < 20 && !order.isCatchException()) {
            count++;
            try {
                order.put(String.valueOf(count));
            }
            catch (InterruptedException e) {
                logger.info(e.getLocalizedMessage());
            }
        }

        order.setOver();
        logger.info("Producer[" + Thread.currentThread().getName() + "] ending...");
    }
}
