package com.jailmango.exercise.java8.ifeve.demo.stream;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * FilterCase
 *
 * @author gang.he2
 * @see com.jailmango.exercise.java8.ifeve.demo.stream
 */
@Slf4j
public class FilterCase {

    /**
     * main
     *
     * @param args
     *            String[]
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {
            {
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
                add("6");
            }
        };

        List<String> result = new ArrayList<>();
        int count = 0;

        for (String s : list) {
            count++;
            if (check1(s)) {
                continue;
            }

            if (check3(s)) {
                continue;
            }

            if (check5(s)) {
                continue;
            }

            result.add(s);
        }


        list.stream().filter(s -> false);

//        List<String> a = Lists.newArrayList("a1", "b1", "c1");
//        List<String> a = Lists.newArrayList("a2", "b3", "c4");

    
        log.info("end...");

    }

    private static boolean check1(String s) {
        return "1".equals(s);
    }

    private static boolean check3(String s) {
        return "3".equals(s);
    }

    private static boolean check5(String s) {
        return "5".equals(s);
    }
}
