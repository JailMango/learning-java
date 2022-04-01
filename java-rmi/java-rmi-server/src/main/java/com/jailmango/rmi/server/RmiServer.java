package com.jailmango.rmi.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RmiServer
 *
 * @author jailmango
 * @CreateDate 2019-07-04
 * @see com.jailmango.rmi.server
 * @since R9.0
 */
@SpringBootApplication
public class RmiServer {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(RmiServer.class);
        Thread.sleep(Long.MAX_VALUE);
    }
}
