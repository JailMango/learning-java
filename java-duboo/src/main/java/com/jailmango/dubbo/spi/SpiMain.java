package com.jailmango.dubbo.spi;

import java.util.ServiceLoader;

/**
 * SpiMain
 *
 * @author jailmango
 * @CreateDate 2019/10/28
 * @see com.jailmango.dubbo.java.spi
 * @since R9.0
 */
public class SpiMain {

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        ServiceLoader<ISpiService> services = ServiceLoader.load(ISpiService.class);

        for (ISpiService service : services) {
            service.sayHello();
        }
    }
}
