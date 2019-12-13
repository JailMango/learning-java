package com.jailmango.spring.boot.runner.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ApplicationRunnerCase1
 *
 * @author he.gang33
 * @CreateDate 2019-07-04
 * @see com.jailmango.spring.boot.runner.component
 * @since R9.0
 */
@Component
@Order(3)
public class ApplicationRunnerCase2 implements ApplicationRunner {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ApplicationRunnerCase2.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("ApplicationRunnerCase2 -> start");

        for (String arg : args.getSourceArgs()) {
            logger.info("Content -> [{}]", arg);
        }

        logger.info("ApplicationRunnerCase2 -> end");
    }
}
