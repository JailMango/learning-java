package com.jailmango.rmi.server.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * RmiServerConfiguration
 *
 * @author he.gang33
 * @CreateDate 2019-07-04
 * @see com.jailmango.rmi.server.configuration
 * @since R9.0
 */
@EnableAutoConfiguration
@ComponentScan(value = {
    "com.jailmango.rmi.server.configuration"
})
public class ServerConfiguration {

}
