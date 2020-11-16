package com.jailmango.concurrence.book.action.chapter06;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_2_3_Lambda表达式
 *
 * @author he.gang33
 * @CreateDate 2020/11/5
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_2_3_Lambda表达式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.forEach(System.out::print);

        System.out.println("");
        System.out.println("---------------------------------------------");

        final int num = 2;
        numbers.forEach(integer -> System.out.print(integer * num));

        System.out.println("");
        System.out.println("---------------------------------------------");

        Function<Integer, Integer> function = integer -> integer * num;
        numbers.forEach(function::apply);
    }
}
