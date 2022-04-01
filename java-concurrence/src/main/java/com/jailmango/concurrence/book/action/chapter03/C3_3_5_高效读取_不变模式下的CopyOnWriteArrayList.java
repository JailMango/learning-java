package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.CopyOnWriteArrayList;

import lombok.extern.slf4j.Slf4j;

/**
 * 高效读取CopyOnWrite
 *
 * @author jailmango
 * @CreateDate 2020/10/20
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_3_5_高效读取_不变模式下的CopyOnWriteArrayList {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("1");
        list.add("2");

        list.get(0);
    }
}
