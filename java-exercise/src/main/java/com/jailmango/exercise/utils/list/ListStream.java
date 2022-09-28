package com.jailmango.exercise.utils.list;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ListStream
 *
 * @author hegang1
 * @CreateDate 2022/8/11
 * @see com.jailmango.exercise.utils.list
 */
@Slf4j
public class ListStream {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "a", "a");

        List<String> result = list.stream().filter(Objects::nonNull).filter(s -> !"a".equals(s)).distinct().collect(Collectors.toList());

        log.info("end...");

        List<Person> personList = new ArrayList<>();
        // 四个参与测试的小伙伴
        Person tom = new Person("tom", "男", 11);
        Person amy = new Person("amy", "女", 13);
        Person ali = new Person("ali", "男", 12);
        Person daming = new Person("daming", "男", 13);
        personList.add(tom);
        personList.add(amy);
        personList.add(ali);
        personList.add(daming);
        // 对小伙伴按照性别age进行分组
        Map<String, Set<String>> resultMap = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.mapping(Person::getName, Collectors.toSet())));
        log.info("{}", resultMap.toString());

    }

    @Data
    private static class Person {

        private String name;

        private String sex;

        private int age;

        private Boolean good;

        public Person(String name, String sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
    }
}