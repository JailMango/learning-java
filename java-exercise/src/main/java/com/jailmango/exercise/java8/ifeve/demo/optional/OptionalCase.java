package com.jailmango.exercise.java8.ifeve.demo.optional;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * OptionalCase
 *
 * @author gang.he2
 * @see com.jailmango.exercise.java8.ifeve.demo.optional
 */
@Slf4j
public class OptionalCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Integer a = null;
        Integer b = 10;

        // Optional.of() 对象不为null，会抛出NullPointerException
        // Optional<Integer> valuea = Optional.of(a);
        // Optional<Integer> valueb = Optional.of(b);

        Optional<Integer> valuea = Optional.ofNullable(a);
        Optional<Integer> valueb = Optional.ofNullable(b);

        log.info("a是否为空: {}", valuea.isPresent());
        log.info("b是否为空: {}", valueb.isPresent());
        log.info("a = {}", valuea.orElse(new Integer(100)));
        log.info("b = {}", valueb.orElse(1000));
        try {
            valuea.orElseThrow((Supplier<Throwable>) () -> new RuntimeException("测试。。。"));
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            log.info("捕获了异常。。。");
        }

        valuea.ifPresent(integer -> log.info("消费[{}]", integer));
        valueb.ifPresent(integer -> log.info("消费[{}]", integer));

        Person p1 = null;
        boolean result = Optional.ofNullable(p1).filter(Person::isSuccess).isPresent();

        p1 = Person.builder().success(true).build();
        result = Optional.ofNullable(p1).filter(Person::isSuccess).isPresent();

        log.info("end...");
    }

    private static Integer sum(Optional<Integer> a, Optional<Integer> b) {

        return 0;
    }

    @Data
    @Builder
    @ToString
    private static class Person {

        private String name;

        private int age;

        private String sex;

        private boolean success;
    }
}
