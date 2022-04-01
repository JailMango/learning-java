package com.jailmango.io.pipe;

import java.io.IOException;
import java.io.PipedOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sender
 *
 * @author jailmango
 * @CreateDate 2019-03-13
 * @see com.jailmango.java.io.pipe
 * @since R9.0
 */
public class Sender implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Sender.class);

    /**
     * 消息模板
     */
    private static final String TEMPLATE = "Message";

    /**
     * 最大循环次数
     */
    private static final int MAX_LOOP_COUNT = 100;

    /**
     * PipedOutputStream
     */
    private PipedOutputStream pos;

    /**
     * Constructor
     */
    public Sender() {
        this.pos = new PipedOutputStream();
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + "is running...");

        try {
            this.pos.write(TEMPLATE.getBytes());
        }
        catch (IOException e) {
            logger.error(e.getMessage());
        }

        if (null != this.pos) {
            try {
                this.pos.close();
            }
            catch (IOException e) {
                logger.error(e.getMessage());
            }
        }
    }

    public PipedOutputStream getPos() {
        return pos;
    }
}
