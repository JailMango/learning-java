package com.jailmango.exercise.java8.ifeve.demo.stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;

import lombok.extern.slf4j.Slf4j;

import com.jailmango.exercise.java8.ifeve.demo.Person;

@Slf4j
/**
 * ListCase
 *
 * @author gang.he2
 * @see com.jailmango.exercise.java8.ifeve.demo.stream
 */
public class ListCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
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

        strings.removeIf(s -> s.equals(""));

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

        log.info("end...");
    }
}
