package com.jailmango.design.pattern.代理模式.动态代理;

import lombok.extern.slf4j.Slf4j;

/**
 * Main
 *
 * @author he.gang33
 * @CreateDate 2021/2/19
 * @see com.jailmango.design.pattern.代理模式.动态代理
 * @since R9.0
 */
@Slf4j
public class Main {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        Brid bridProxy = (Brid) cglibProxy.createProxy(Brid.class);
        bridProxy.fly();

        AirPlane airPlaneProxy = (AirPlane) cglibProxy.createProxy(AirPlane.class);
        airPlaneProxy.fly();

        log.info("main end...");
    }
}
