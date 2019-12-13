package com.jailmango.spring.boot.runner.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * CommandRunnerCase1
 *
 * @author he.gang33
 * @CreateDate 2019-07-04
 * @see com.jailmango.spring.boot.runner.component
 * @since R9.0
 */
@Component
@Order(1)
public class CommandLineRunnerCase1 implements CommandLineRunner {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CommandLineRunnerCase1.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("CommandLineRunnerCase1 -> start");

        for (String arg : args) {
            logger.info("Content -> [{}]", arg);
        }

        logger.info("CommandLineRunnerCase1 -> end");
    }
}
