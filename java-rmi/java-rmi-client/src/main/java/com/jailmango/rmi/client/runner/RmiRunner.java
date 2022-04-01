package com.jailmango.rmi.client.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jailmango.rmi.entity.UserDto;
import com.jailmango.rmi.service.IUserService;

/**
 * RmiRunner
 *
 * @author jailmango
 * @CreateDate 2019-07-04
 * @see com.jailmango.rmi.client.runner
 * @since R9.0
 */
@Component
public class RmiRunner implements CommandLineRunner {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(RmiRunner.class);

    /**
     * userService
     */
    @Autowired
    private IUserService userService;

    @Override
    public void run(String... args) throws Exception {
        UserDto user = userService.queryUser(1L);
        logger.info("{}", user.getName());
    }
}
