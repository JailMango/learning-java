package com.jailmango.design.pattern.proxy.entertainment.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * CounterA 柜台A
 *
 * @author he.gang33
 * @CreateDate 2018/10/23
 * @see com.jailmango.design.pattern.proxy.entertainment.dynamic
 * @since R9.0<br>
 */
public class CounterA implements InvocationHandler {

    /**
     * Brand
     */
    private Object brand;

    /**
     * Constructor
     * 
     * @param brand Object
     */
    public CounterA(Object brand) {
        this.brand = brand;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Starting...");
        System.out.println("Brand: " + this.getClass().getSimpleName());
        method.invoke(brand, args);
        System.out.println("Ending...");
        return null;
    }
}
