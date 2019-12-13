package com.jailmango.jdk.source.interview.basic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * StaticClass
 *
 * @author he.gang33
 * @CreateDate 2019/10/29
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public class StaticClass extends ParentStaticClass {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(StaticClass.class);

    /**
     * LIST
     */
    public static final List<String> LIST = new ArrayList<String>() {

        /**
         * serialVersionUID
         */
        private static final long serialVersionUID = -5577628293752019229L;

        {
            logger.info("子类静态成员变量LIST初始化...");
        }
    };

    static {
        logger.info("子类静态代码块初始化...");
    }

    public StaticClass() {
        logger.info("子类构造器初始化...");
    }

    public static void testStatic() {
        logger.info("子类静态方法被调用...");
    }

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        logger.info("main start...");

        new StaticClass();
    }

}
