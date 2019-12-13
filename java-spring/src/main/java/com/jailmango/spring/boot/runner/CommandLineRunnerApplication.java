package com.jailmango.spring.boot.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * CommandRunnerApplication
 *
 * @author he.gang33
 * @CreateDate 2019-07-04
 * @see com.jailmango.spring.boot.runner
 * @since R9.0
 */
@SpringBootApplication
public class CommandLineRunnerApplication {

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        SpringApplication.run(CommandLineRunnerApplication.class, args);
    }
}
