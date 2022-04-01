package com.jailmango.design.pattern.proxy.entertainment.normal;

/**
 * ProxyTestCase 静态代理
 *
 * @author jailmango
 * @CreateDate 2018/10/23
 * @see com.jailmango.design.pattern.proxy.entertainment
 * @since R9.0<br>
 */
public class ProxyTestCase {

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        RealMovie realMovie = new RealMovie();
        Movie movie = new Cinema(realMovie);
        movie.play();
    }
}
