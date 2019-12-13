package com.jailmango.guava.ifeve.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

/**
 * UsingAndAvoidingNull
 *
 * @author he.gang33
 * @CreateDate 2019-03-21
 * @see com.jailmango.java.guava.ifeve.chapter01
 * @since R9.0
 */
public class UsingAndAvoidingNull {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(UsingAndAvoidingNull.class);

    /**
     * Symbol
     */
    private static final String SYMBOL = "=======================================";

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String str = "Hello World...";
        Optional<String> optional = Optional.of(str);
        logger.info("Or null: [" + optional.orNull() + "]");
        logger.info("Is present: [" + optional.isPresent() + "]");
        logger.info("Get: [" + optional.get() + "]");
        logger.info(SYMBOL);

        Optional<String> absentOptional = Optional.absent();
        logger.info("Or null: [" + absentOptional.orNull() + "]");
        logger.info("Or: [" + absentOptional.or("default") + "]");
        logger.info("Is present: [" + absentOptional.isPresent() + "]");
        // 引用缺失的实例，调用get方法会报错。
        // logger.info("Get: [" + absentOptional.get() + "]");
        logger.info(SYMBOL);

        logger.info("end...");
    }

    /**
     * doAction
     * 
     * @param str String
     */
    // private void doAction(String str) {
    // logger.info("doAction start...");
    //
    // Optional<String> optional = Optional.of(str);
    // logger.info("Or null: [" + optional.orNull() + "]");
    // logger.info("Is present: [" + optional.isPresent() + "]");
    // logger.info("Get: [" + optional.get() + "]");
    //
    // logger.info("doAction end...");
    // logger.info(SYMBOL);
    // }
}
