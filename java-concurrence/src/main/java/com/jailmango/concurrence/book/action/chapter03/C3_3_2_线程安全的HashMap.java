package com.jailmango.concurrence.book.action.chapter03;

import java.util.Collections;
import java.util.HashMap;

/**
 * 线程安全的HashMap_3_3_2
 *
 * @author he.gang33
 * @CreateDate 2020/10/9
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
public class C3_3_2_线程安全的HashMap {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Collections.synchronizedMap(new HashMap<>());
    }
}
