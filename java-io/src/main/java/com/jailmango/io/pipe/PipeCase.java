package com.jailmango.io.pipe;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * PipeCase
 *
 * @author jailmango
 * @CreateDate 2019-03-13
 * @see com.jailmango.java.io.pipe
 * @since R9.0
 */
public class PipeCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PipeCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Sender send = new Sender();
        Receiver receiver = new Receiver();

        try {
            send.getPos().connect(receiver.getPis());
        }
        catch (IOException e) {
            logger.error(e.getMessage());
        }

        Thread senderThread = new Thread(send);
        Thread recevierThread = new Thread(receiver);

        senderThread.start();
        recevierThread.start();
    }
}
