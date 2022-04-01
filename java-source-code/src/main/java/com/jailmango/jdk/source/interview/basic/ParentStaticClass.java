package com.jailmango.jdk.source.interview.basic;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ParentClass
 *
 * @author jailmango
 * @CreateDate 2019/10/29
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public class ParentStaticClass {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ParentStaticClass.class);

    /**
     * PARENT_LIST
     */
    public static final List<String> PARENT_LIST = new ArrayList<String>() {

        /**
         * serialVersionUID
         */
        private static final long serialVersionUID = -235786109016248995L;

        {
            logger.info("父类静态成员变量PARENT_LIST初始化...");
        }
    };

    static {
        logger.info("父类static代码块初始化...");
    }

    /**
     * Constructor
     */
    public ParentStaticClass() {
        logger.info("父类构造器初始化...");
    }

    /**
     * testStatic
     */
    public static void testStatic() {
        logger.info("父类静态方法被调用...");
    }

}
