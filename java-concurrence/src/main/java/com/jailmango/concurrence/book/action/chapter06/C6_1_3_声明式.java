package com.jailmango.concurrence.book.action.chapter06;

import java.util.Arrays;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_1_3_声明式
 *
 * @author he.gang33
 * @CreateDate 2020/11/5
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_1_3_声明式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String[] array = {
            "1", "2", "3", "4", "5"
        };

        for (int index = 0; index < array.length; index++) {
            log.info("index -> {}", array[index]);
        }

        log.info("====================================");

        Arrays.stream(array).forEach(s -> log.info("index -> {}", s));

        System.out.println("end...");
    }
}
