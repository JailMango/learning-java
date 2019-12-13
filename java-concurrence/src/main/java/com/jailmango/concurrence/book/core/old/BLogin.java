package com.jailmango.concurrence.book.core.old;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * BLogin
 *
 * @author he.gang33
 * @CreateDate 2018/11/20
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class BLogin implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ALogin.class);

    @Override
    public void run() {
        try {
            LoginServlet.doPost("b", "b");
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }
    }
}
