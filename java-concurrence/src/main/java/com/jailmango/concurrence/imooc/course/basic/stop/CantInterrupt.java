package com.jailmango.concurrence.imooc.course.basic.stop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CantInterrupt <br/>
 * Chapter5-5 <br/>
 * 如果while(){}里面放try-catch，会导致中断失效，sleep()会清空interrupt中断标记位
 * 
 * @author jailmango
 * @CreateDate 2020/4/15
 * @see com.jailmango.concurrence.imooc.course.basic.stop
 * @since R9.0
 */
public class CantInterrupt {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CantInterrupt.class);

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;

            while (!Thread.currentThread().isInterrupted() && num <= 10000) {
                if (num % 100 == 0) {
                    logger.info("{}是100的倍数...", num);
                }
                num++;
                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
