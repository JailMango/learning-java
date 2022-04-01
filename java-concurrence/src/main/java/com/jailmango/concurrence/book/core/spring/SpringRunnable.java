package com.jailmango.concurrence.book.core.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * SpringRunnable
 *
 * @author jailmango
 * @CreateDate 2018-11-23
 * @see com.jailmango.java.book.core.spring
 * @since R9.0<br>
 */
@Component
@Async
public class SpringRunnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SpringRunnable.class);

    /**
     * doJob
     */
    public void doJob() {
        while (true) {
            logger.info(Thread.currentThread().getName() + " is doing job...");
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                logger.error(e.getLocalizedMessage());
            }
        }
    }
}
