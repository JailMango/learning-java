package com.jailmango.concurrence.imooc.course.basic.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CantStartTwiceCase 不能两次调用start()方法，否则会报错
 * 
 * @author he.gang33
 * @CreateDate 2020/4/14
 * @see com.jailmango.concurrence.imooc.course.basic.start
 * @since R9.0
 */
public class CantStartTwiceCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CantStartTwiceCase.class);

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }

}
