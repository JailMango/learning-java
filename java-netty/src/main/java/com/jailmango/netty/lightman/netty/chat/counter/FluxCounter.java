package com.jailmango.netty.lightman.netty.chat.counter;

/**
 * FluxCounter
 *
 * @author he.gang33
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.chat.counter
 * @since R9.0
 */
public class FluxCounter {

    /**
     * 总流量
     */
    private Long count;

    public FluxCounter() {
        this.count = 0L;
    }

    public Long record(int amount) {
        this.count += amount;
        return this.count;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
