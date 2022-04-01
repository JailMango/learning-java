package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * C_6_8_2_ConcurrentHashMap增加_Reduce
 *
 * @author jailmango
 * @CreateDate 2020/11/12
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_8_2_ConcurrentHashMap增加_Reduce {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 100; i++) {
            map.put(Integer.toString(i), i);
        }

        int count = map.reduceValues(2, (m, n) -> m + n);

        log.info("{}", count);
    }
}
