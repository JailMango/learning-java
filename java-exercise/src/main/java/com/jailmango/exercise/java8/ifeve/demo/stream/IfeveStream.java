package com.jailmango.exercise.java8.ifeve.demo.stream;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * IfeveStream
 *
 * @author jailmango
 * @see com.jailmango.exercise.java8.ifeve.demo.stream
 */
@Slf4j
public class IfeveStream {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1, 2, null, 3, 4, null, 5);

        long nonNullCount = list.stream().filter(Objects::nonNull).count();
        log.info("非空的个数: {}", nonNullCount);

        Stream<Integer> integerStreamtream = Stream.of(1, 2, 3, null, 4, null, 5);
        Stream<String> stringStream = Stream.of("1", "2", "3", null, "", " ", "4");

        Stream.generate(Math::random).limit(10).forEach(num -> log.info("{}", num));
        Stream.iterate(1, num -> num + 1).limit(10).forEach(num -> log.info("{}", num));
    }
}
