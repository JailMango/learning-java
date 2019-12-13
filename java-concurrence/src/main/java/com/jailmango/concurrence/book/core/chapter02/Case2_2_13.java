package com.jailmango.concurrence.book.core.chapter02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_2_13 - 2.2.13 类Class的单例性
 *
 * @author he.gang33
 * @CreateDate 2019-05-27
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_2_13 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_2_13.class);

    public static void main(String[] args) {
        SingletonClass ins1 = new SingletonClass("a");
        SingletonClass ins2 = new SingletonClass("b");

        if (ins1.getClass() == ins2.getClass()) {
            logger.info("Instance1 class is equals to Instance2 class...");
            logger.info("Class object is singleton...");
        }

    }

    static class SingletonClass {
        private String name;

        public SingletonClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
