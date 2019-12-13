package com.jailmango.design.pattern.proxy.entertainment.normal;

/**
 * RealMovie
 *
 * @author he.gang33
 * @CreateDate 2018/10/23
 * @see com.jailmango.design.pattern.proxy.entertainment
 * @since R9.0<br>
 */
public class RealMovie implements Movie {

    @Override
    public void play() {
        System.out.println("Playing real movie.");
    }
}
