package com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SleepDontReleaseMonitor <br/>
 * sleep()不释放synchronized的monitor,等sleep时间到了以后，正常结束之后才释放锁
 * 
 * @author he.gang33
 * @CreateDate 2020/6/4
 * @see com.jailmango.concurrence.imooc.course.basic.threadobjectclasscommonmethod
 * @since R9.0
 */
public class SleepDontReleaseMonitor implements Runnable {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SleepDontReleaseMonitor.class);

    @Override
    public void run() {

    }

    private synchronized void syn() {
        logger.info("Thread[{}] get monitor");
    }
}
