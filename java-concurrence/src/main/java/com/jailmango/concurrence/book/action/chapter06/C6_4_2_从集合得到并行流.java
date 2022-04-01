package com.jailmango.concurrence.book.action.chapter06;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * C6_4_2_从集合得到并行流
 *
 * @author jailmango
 * @CreateDate 2020/11/10
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_4_2_从集合得到并行流 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            list.add(new Student(i));
        }

        double average = list.stream().mapToInt(value -> value.score).average().getAsDouble();
        log.info("Average = {}", average);
    }

    @Data
    @AllArgsConstructor
    @ToString
    private static class Student {
        int score;
    }
}
