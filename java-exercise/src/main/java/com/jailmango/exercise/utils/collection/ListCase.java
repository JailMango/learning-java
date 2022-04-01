package com.jailmango.exercise.utils.collection;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ListCase
 *
 * @author he.gang33
 * @CreateDate 2019-01-24
 * @see com.jailmango.exercise.utils.collection
 * @since R9.0
 */
@Slf4j
public class ListCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[] {
            "1", "2"
        });


        List<Person> list1 = Lists.newArrayList();

        List<String> result = list1.stream().map(Person::getName).collect(Collectors.toList());
        log.info("end...");
    }

    @Data
    private static class Person {

        private String name;
    }
}
