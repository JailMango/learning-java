package com.jailmango.rmi.client.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * ClientConfiguration
 *
 * @author he.gang33
 * @CreateDate 2019-07-04
 * @see com.jailmango.rmi.client.configuration
 * @since R9.0
 */
@EnableAutoConfiguration
@ComponentScan(value = {
    "com.jailmango.rmi.client.configuration"
})
public class ClientConfiguration {
}
