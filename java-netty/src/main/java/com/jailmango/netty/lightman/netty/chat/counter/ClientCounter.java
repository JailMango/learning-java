package com.jailmango.netty.lightman.netty.chat.counter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ClientCounter
 */
public enum ClientCounter {

    /**
     * INSTANCE
     */
    INSTANCE;

    /**
     * list
     */
    private AtomicLong count;

    /**
     * Constructor
     */
    ClientCounter() {
        init();
    }

    /**
     * fillData
     */
    private void init() {
        this.count = new AtomicLong(0);
    }

    /**
     * connect
     * 
     * @return long
     */
    public long connect() {
        return this.count.incrementAndGet();
    }

    /**
     * disconnect
     * 
     * @return long
     */
    public long disconnect() {
        return this.count.decrementAndGet();
    }

    /**
     * getClientCount
     * 
     * @return long
     */
    public long getClientCount() {
        return this.count.get();
    }

}
