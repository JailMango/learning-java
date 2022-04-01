package com.jailmango.design.pattern.proxy.entertainment.dynamic.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CglibProxy
 *
 * @author jailmango
 * @CreateDate 2018/11/12
 * @see com.jailmango.java.proxy.entertainment.dynamic.cglib
 * @since R9.0<br>
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before...");
        Object retnObj = methodProxy.invoke(o, objects);
        System.out.println("after...");

        return retnObj;
    }
}
