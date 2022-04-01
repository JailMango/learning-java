package com.jailmango.concurrence.book.core.chapter02;

/**
 * Case2_1_3 - synchronized在字节码指令中的原理
 *
 * @author jailmango
 * @CreateDate 2019-05-23
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_1_3 {

    public static void main(String[] args) {

    }

    public synchronized static void staticMethod() {

    }

    public void insMethod() {
        synchronized (this) {

        }
    }
}
