package com.jailmango.io.pipe;

import java.io.IOException;
import java.io.PipedInputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Receiver
 *
 * @author he.gang33
 * @CreateDate 2019-03-13
 * @see com.jailmango.java.io.pipe
 * @since R9.0
 */
public class Receiver implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    /**
     * PipedInputStream
     */
    private PipedInputStream pis;

    /**
     * Constructor
     */
    public Receiver() {
        this.pis = new PipedInputStream();
    }

    @Override
    public void run() {
        logger.info(Thread.currentThread().getName() + "is running...");

        byte[] byteArr = new byte[1024];
        int length = 0;

        try {
            length = this.pis.read(byteArr);
        }
        catch (IOException e) {
            logger.error(e.getMessage());
        }

        logger.info("Receive:[" + new String(byteArr, 0, length) + "]");
    }

    public PipedInputStream getPis() {
        return pis;
    }
}
