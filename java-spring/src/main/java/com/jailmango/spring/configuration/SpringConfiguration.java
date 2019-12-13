package com.jailmango.spring.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * SpringConfiguration
 *
 * @author he.gang33
 * @CreateDate 2019-07-03
 * @see com.jailmango.spring.configuration
 * @since R9.0
 */
@EnableAutoConfiguration
@ComponentScan(value = {
    "com.jailmango.spring.framework.bean.configuration"
})
public class SpringConfiguration {

}
