package com.jailmango.exercise.utils.stream;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

/**
 * StreamCase
 *
 * @author gang.he2
 * @CreateDate 2022/3/25
 * @see com.jailmango.exercise.utils.stream
 */
public class StreamCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Map<Integer, List<Person>> map = new HashMap<>() {
            {
                put(1, Lists.newArrayList(new Person("11", 11), new Person("12", 12), new Person("13", 13)));
                put(2, Lists.newArrayList(new Person("21", 21), new Person("22", 22), new Person("23", 23)));
                put(3, Lists.newArrayList(new Person("31", 31), new Person("32", 32), new Person("33", 33)));
            }
        };

        Optional.ofNullable(map).flatMap(new Function<Map<Integer, List<Person>>, Optional<?>>() {
            @Override
            public Optional<?> apply(Map<Integer, List<Person>> integerListMap) {
                return Optional.empty();
            }
        })
    }

    private static class Person {

        private String name;

        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
