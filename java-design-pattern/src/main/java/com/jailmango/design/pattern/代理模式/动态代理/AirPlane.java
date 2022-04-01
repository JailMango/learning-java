package com.jailmango.design.pattern.代理模式.动态代理;

import lombok.extern.slf4j.Slf4j;

/**
 * AirPlane
 *
 * @author jailmango
 * @CreateDate 2021/2/19
 * @see com.jailmango.design.pattern.代理模式.动态代理
 * @since R9.0
 */
@Slf4j
public class AirPlane implements Flyable {

    @Override
    public void fly() {
        log.info("AirPlane flying...");
    }
}
