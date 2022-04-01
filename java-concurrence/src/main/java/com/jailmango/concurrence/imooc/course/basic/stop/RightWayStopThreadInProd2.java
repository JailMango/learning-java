package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RightWayStopThreadInProd2 <br/>
 * Chapter5-8 <br/>
 * 在catch语句中调用Thread.currentThread().interrupt()来恢复设置中断状态 <br/>
 * 以便于在后续的执行中，依然能够检查到刚才发生的中断。 回到刚才RightWayStopThreadInProd补上中断，让他跳出.
 * 
 * @author jailmango
 * @CreateDate 2020/4/16
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class RightWayStopThreadInProd2 implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RightWayStopThreadInProd2.class);

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                logger.info("interrupt...");
                break;
            }
            throwInMethod();
        }
    }

    private void throwInMethod() {
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
