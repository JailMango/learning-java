package com.jailmango.concurrence.pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Order
 *
 * @author he.gang33
 * @CreateDate 2018/11/21
 * @see com.jailmango.java.pattern
 * @since R9.0<br>
 */
public class Order {

    /**
     * logger
     */
    public static final Logger logger = LoggerFactory.getLogger(Order.class);

    /**
     * 缓冲区
     */
    private final String[] buffer;

    /**
     * 下一个put的地方
     */
    private int tail;

    /**
     * 下一个get的地方
     */
    private int head;

    /**
     * 缓冲记录数
     */
    private int count;

    /**
     * 是否结束处理
     */
    private volatile boolean over = false;

    /**
     * catchException
     */
    private volatile boolean catchException = false;

    /**
     * Constructor
     * 
     * @param count int
     */
    public Order(int count) {
        logger.info("Order - constructor - start");
        this.buffer = new String[count];
        this.tail = 0;
        this.head = 0;
        this.count = 0;
        logger.info("Order - constructor - end");
    }

    /**
     * 填充缓冲区
     * 
     * @param lineStr String
     * @throws InterruptedException InterruptedException
     */
    public synchronized void put(String lineStr) throws InterruptedException {
        logger.info("Order - put - start");

        while (count >= buffer.length) {
            logger.info("Order - put->waiting");
            wait();
            logger.info("Order - put->wait - end");
        }

        buffer[tail] = lineStr;
        tail = (tail + 1) % buffer.length;
        count++;
        notifyAll();
        logger.info("Order - put[" + lineStr + "] - end");
    }

    /**
     * 从缓冲区取一条数据
     * 
     * @return String
     * @throws InterruptedException InterruptedException
     */
    public synchronized String get() throws InterruptedException {
        logger.info("Order - get - start");

        while (count <= 0 && !this.over) {
            logger.info("Order - get->waiting");
            wait();
            logger.info("Order - get->wait - end");
        }

        if (count <= 0) {
            logger.info("Order - get - end");
            return null;
        }
        else {
            String lineStr = buffer[head];
            head = (head + 1) % buffer.length;
            count--;
            notifyAll();
            logger.info("Order - get[" + lineStr + "] - end");
            return lineStr;
        }

    }

    /**
     * 判断是否已完成
     * 
     * @return boolean
     */
    public synchronized boolean isOver() {
        // logger.info("Order - isOver - start");
        // logger.info("Order - isOver - end");
        return this.over;
    }

    /**
     * 标记为完成，表示一个文件已经全部缓冲结束
     */
    public synchronized void setOver() {
        // logger.info("Order - setOver - start");
        this.over = true;
        notifyAll(); // 这里一定要通知消费者，告诉他们不要再等了，game已经over啦~
        // logger.info("Order - setOver - end");
    }

    /**
     * 缓冲区中剩余数量
     * 
     * @return int
     */
    public int size() {
        // logger.info("Order - size - start");
        // logger.info("Order - size - end");
        return count;
    }

    /**
     * 判断缓冲区是否为空
     * 
     * @return boolean
     */
    public boolean isEmpty() {
        // logger.info("Order - isEmpty - start");

        if (count > 0) {
            // logger.info("Order - isEmpty - end");
            return false;
        }
        // logger.info("Order - isEmpty - end");
        return true;
    }

    /**
     * isCatchException
     * 
     * @return boolean
     */
    public synchronized boolean isCatchException() {
        logger.info("Order - isCatchException[" + this.catchException + "] - end");
        return this.catchException;
    }

    /**
     * setCatchException
     */
    public synchronized void setCatchException() {
        this.catchException = true;
        notifyAll();
        logger.info("Order - setCatchException[" + this.catchException + "] - end");
    }
}
