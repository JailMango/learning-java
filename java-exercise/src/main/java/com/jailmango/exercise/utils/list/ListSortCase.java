package com.jailmango.exercise.utils.list;

import lombok.extern.slf4j.Slf4j;

/**
 * ListSortCase
 *
 * @author jailmango
 * @CreateDate 2021/8/24
 * @see com.jailmango.exercise.utils.list
 * @since R9.0
 */
@Slf4j
public class ListSortCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }

    private static class Person  {

        private String name;

        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
