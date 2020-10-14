package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StopThread <br/>
 * Chapter5-10 <br/>
 * 错误的停止方法：用stop()来停止线程，会导致线程运行到一半突然停止 <br/>
 * 没办法完成一个基本单位的操作(一个连队)，会造成脏数据(有的连队多领取或少领取装备)
 * 
 * @author he.gang33
 * @CreateDate 2020/4/19
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class StopThread implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StopThread.class);

    @Override
    public void run() {
        // 模拟指挥部队：一共有5个连队，每个连队10人，以连队为单位，发放装备
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    Thread.sleep(50);
                    logger.info("[{}-{}]已领取...", i, j);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            logger.info("连队[{}]已领取完毕...", i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
