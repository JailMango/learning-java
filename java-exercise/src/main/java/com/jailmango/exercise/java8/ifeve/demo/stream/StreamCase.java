package com.jailmango.exercise.java8.ifeve.demo.stream;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * StreamCase
 *
 * @author gang.he2
 * @see com.jailmango.exercise.java8.ifeve.demo.stream
 */
@Slf4j
public class StreamCase {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {
        List<Person> searchResult = Lists.newArrayList();

        for (int i = 0; i < 20; i++) {
            searchResult.add(Person.builder().name("name-" + i).id(i).sex(i % 2 == 0 ? "Male" : "Female").comment("Comment-" + i).build());
        }

        List<Person> personList = Lists.newArrayList();
        for (int i = 0; i < 20; i++) {
            personList.add(Person.builder().name("name-" + i * 2).id(i).build());
        }

        List<Integer> ids = personList.stream().filter(person -> pick()).map(Person::getId).collect(Collectors.toList());

        Map<Integer, Person> map =
            personList.stream().filter(p -> ids.contains(p.getId())).collect(Collectors.toMap(Person::getId, Function.identity(), (oldVal, newVal) -> newVal));

        log.info("end...");
    }

    private static boolean pick() {
        return new SecureRandom().nextInt(10) <= 4;
    }

    @Data
    @Builder
    @ToString
    private static class Person {

        private Integer id;

        private String name;

        private String sex;

        private String comment;
    }
}
