package com.jailmango.design.pattern.proxy.entertainment.dynamic.jdk;

/**
 * MaoTai
 *
 * @author jailmango
 * @CreateDate 2018/10/23
 * @see com.jailmango.design.pattern.proxy.entertainment.dynamic
 * @since R9.0<br>
 */
public class MaoTai implements License {

    @Override
    public void sell() {
        System.out.println("Sell MaoTai.");
    }
}
