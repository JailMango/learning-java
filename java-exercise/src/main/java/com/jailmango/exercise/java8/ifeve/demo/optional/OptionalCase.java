package com.jailmango.exercise.java8.ifeve.demo.optional;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import com.jailmango.exercise.java8.ifeve.demo.Person;
import lombok.extern.slf4j.Slf4j;

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

//
//        Person si = new Person("SiJunHeng", 30);
//        Person he = null;



    }

    private static Integer sum(Optional<Integer> a, Optional<Integer> b) {

        return 0;
    }
}
