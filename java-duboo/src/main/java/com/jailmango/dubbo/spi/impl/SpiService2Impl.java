package com.jailmango.dubbo.spi.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.dubbo.spi.ISpiService;

/**
 * SpiServiceImpl
 *
 * @author jailmango
 * @CreateDate 2019/10/23
 * @see com.jailmango.dubbo.java.spi.impl
 * @since R9.0
 */
public class SpiService2Impl implements ISpiService {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SpiService2Impl.class);

    @Override
    public void sayHello() {
        logger.info("SPI Service-2 say hello...");
    }
}
