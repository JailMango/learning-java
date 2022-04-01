package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_8_4_Search操作
 *
 * @author jailmango
 * @CreateDate 2020/11/12
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_8_4_Search操作 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 1000; i++) {
            map.put(Integer.toString(i), i);
        }

        int found = map.search(2, (key, value) -> {
            if (value % 25 == 0) {
                return value;
            }
            return null;
        });

        log.info("Result = {}", found);
    }

}
