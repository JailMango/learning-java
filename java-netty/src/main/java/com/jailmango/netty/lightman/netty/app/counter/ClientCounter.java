package com.jailmango.netty.lightman.netty.app.counter;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 客户端数量计数器
 */
public enum ClientCounter {

    /**
     * INSTANCE
     */
    INSTANCE;

    /**
     * total
     */
    private AtomicLong total;

    /**
     * Constructor
     */
    ClientCounter() {
        this.init();
    }

    /**
     * init
     */
    private void init() {
        this.total = new AtomicLong(0);
    }

    /**
     * 上线计数
     * 
     * @return long
     */
    public long connect() {
        return this.total.incrementAndGet();
    }

    /**
     * 下线计数
     * 
     * @return long
     */
    public long disconnect() {
        return this.total.decrementAndGet();
    }

    /**
     * 获取当前客户端数量
     * 
     * @return long
     */
    public long getCount() {
        return this.total.get();
    }
}
