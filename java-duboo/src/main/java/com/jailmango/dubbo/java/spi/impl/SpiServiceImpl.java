package com.jailmango.dubbo.java.spi.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.dubbo.java.spi.ISpiService;

/**
 * SpiServiceImpl
 *
 * @author he.gang33
 * @CreateDate 2019/10/23
 * @see com.jailmango.dubbo.java.spi.impl
 * @since R9.0
 */
public class SpiServiceImpl implements ISpiService {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SpiServiceImpl.class);

    @Override
    public void sayHello() {
        logger.info("SPI Service say hello...");
    }
}
