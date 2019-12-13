package com.jailmango.spring.boot.runner.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * CommandLineRunnerConfiguration
 *
 * @author he.gang33
 * @CreateDate 2019-07-04
 * @see com.jailmango.spring.boot.runner.configuration
 * @since R9.0
 */
@EnableAutoConfiguration
@ComponentScan(value = {
        "com.jailmango.spring.boot.runner.component"
})
public class CommandLineRunnerConfiguration {

}
