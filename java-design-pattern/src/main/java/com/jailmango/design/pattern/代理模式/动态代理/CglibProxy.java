package com.jailmango.design.pattern.代理模式.动态代理;

import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CglibProxy
 *
 * @author he.gang33
 * @CreateDate 2021/2/19
 * @see com.jailmango.design.pattern.代理模式.动态代理
 * @since R9.0
 */
@Slf4j
public class CglibProxy implements MethodInterceptor {

    public Object createProxy(Class clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object sub, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        log.info("before advice...");
        Object result = methodProxy.invokeSuper(sub, args);
        Thread.sleep(500);
        log.info("after advice...");
        long end = System.currentTimeMillis();
        log.info("Cost:[{}]", end - start);

        return result;
    }
}
