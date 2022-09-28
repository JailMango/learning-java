package com.jailmango.algorithm;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Sort
 *
 * @author gang.he2
 * @CreateDate 2022/4/14
 * @see com.jailmango.algorithm
 */
@Slf4j
public class Sort {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Person p1 = new Person(1);
        Person p2 = new Person(2);
        Person p3 = new Person(3);
        Person p4 = new Person(4);

        List<Person> list = Lists.newArrayList(p2, p3, p1, p4);

        Collections.sort(list, new PersonAgeComparator());

        log.info("{}", list);

        int a = 1;
    }

    @Data
    private static class Person {

        private int age;

        public Person(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("Person{");
            sb.append("age=").append(age);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class PersonAgeComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge() >= o2.getAge() ? 1 : -1;
        }
    }
}
