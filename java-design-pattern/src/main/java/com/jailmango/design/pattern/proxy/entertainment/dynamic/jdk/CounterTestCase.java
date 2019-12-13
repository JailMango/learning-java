package com.jailmango.design.pattern.proxy.entertainment.dynamic.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * CounterTestCase
 *
 * @author he.gang33
 * @CreateDate 2018/10/23
 * @see com.jailmango.design.pattern.proxy.entertainment.dynamic
 * @since R9.0<br>
 */
public class CounterTestCase {

    public static void main(String[] args) {
        MaoTai maoTai = new MaoTai();
        InvocationHandler counterA = new CounterA(maoTai);

        License dynamicProxy = (License) Proxy.newProxyInstance(MaoTai.class.getClassLoader(),
            MaoTai.class.getInterfaces(), counterA);

        dynamicProxy.sell();
    }
}
