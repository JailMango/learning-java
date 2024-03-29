package com.jailmango.exercise.java8.ifeve.demo.stream;

import com.google.common.collect.Lists;
import com.jailmango.exercise.java8.ifeve.demo.Person;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Slf4j
/**
 * ListCase
 *
 * @author jailmango
 * @see com.jailmango.exercise.java8.ifeve.demo.stream
 */
public class ListCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<String> list3 = new ArrayList<>();
        for (String s : list3) {
            log.info("kong");
        }

        log.info("------------------------------------");

        List<String> strings = new ArrayList<String>() {
            {
                add("abc");
                add("");
                add("bc");
                add("efg");
                add("abcd");
                add("");
                add("jkl");
            }
        };

        List<String> result1 = strings.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return StringUtils.isNotBlank(s);
            }
        }).collect(Collectors.toList());

        strings.removeIf(s -> s.equals(""));


        List<String> result2 = strings.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        }).collect(Collectors.toList());

        List<Long> result = new ArrayList<Long>() {
            {
                add(1L);
                add(2L);
                add(3L);
                add(4L);
                add(5L);
                add(6L);
            }
        };

        Long max = result.get(0);

        for (Long value : result) {
            if (value.compareTo(max) > 0) {
                max = value;
            }
        }

        Date now = new Date();

        Person p1 = Person.builder().birth(DateUtils.addSeconds(now, 0)).build();
        Person p2 = Person.builder().birth(DateUtils.addSeconds(now, -1)).build();
        Person p3 = Person.builder().birth(DateUtils.addSeconds(now, 6)).build();
        Person p4 = Person.builder().birth(DateUtils.addSeconds(now, -3)).build();
        Person p5 = Person.builder().birth(DateUtils.addSeconds(now, 2)).build();

        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);

        List<List<Person>> partitionResult = Lists.partition(list, 2);

        log.info("end...");
    }
}
