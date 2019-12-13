package com.jailmango.concurrence.book.core.old;

/**
 * RunServlet
 *
 * @author he.gang33
 * @CreateDate 2018/11/20
 * @see com.jailmango.java.book.core.chapter01
 * @since R9.0<br>
 */
public class RunServlet {

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        Thread a = new Thread(new ALogin());
        Thread b = new Thread(new BLogin());

        a.start();
        b.start();
    }
}
