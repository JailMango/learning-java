package com.jailmango.concurrence.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Consumer
 *
 * @author jailmango
 * @CreateDate 2018/11/21
 * @see com.jailmango.concurrence.pattern
 * @since R9.0<br>
 */
public class Consumer implements Runnable {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(Consumer.class);

    /**
     * order
     */
    private Order order;

    /**
     * Constructor
     * 
     * @param order Order
     */
    public Consumer(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        logger.info("Consumer[" + Thread.currentThread().getName() + "] starting...");
        while ((!order.isOver() || !order.isEmpty()) && !order.isCatchException()) {
            logger.info("Consumer[" + Thread.currentThread().getName() + "] is consuming...start");
            try {
                doBusi(order.get());
            }
            catch (InterruptedException e) {
                logger.info(e.getLocalizedMessage());
            }
            catch (Exception e) {
                logger.info(e.getLocalizedMessage());
                order.setCatchException();
            }
            logger.info("Consumer[" + Thread.currentThread().getName() + "] is consuming...end");
        }
        logger.info("Consumer[" + Thread.currentThread().getName() + "] ending...");
    }

    /**
     * doBusi
     * 
     * @param order String
     * @throws Exception Exception
     */
    private void doBusi(String order) throws Exception {
        logger.info("Consumer - doBusi - start");

        if ("3".equals(order)) {
            logger.info("Consumer throws exception");
            throw new Exception("Consume exception");
        }

        logger.info("Consume Order[" + order + "]");
        logger.info("Consumer - doBusi - end");
    }
}
