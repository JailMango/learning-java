package com.jailmango.concurrence.book.action.chapter06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * C6_2_4_方法引用
 *
 * @author jailmango
 * @CreateDate 2020/11/6
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_2_4_方法引用 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        System.out.println("User");
        List<User> users = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            users.add(new User("User-" + i, i));
        }
        users.stream().map(User::getName).forEach(System.out::println);

        System.out.println("===================================");

        System.out.println("Double");

        List<Double> doubles = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            doubles.add((double) i);
        }
        doubles.stream().map((Function<Double, Object>) Object::toString).forEach(System.out::println);

        User user = userFactory.getInstance("interface-user", 0);
        System.out.println(user);
    }

    static UserFactory<User> userFactory = User::new;

    @FunctionalInterface
    private interface UserFactory<T extends User> {
        T getInstance(String name, int age);
    }

    @ToString
    private static class User {

        private String name;

        private int age;

        public User(String name, int age) {
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
