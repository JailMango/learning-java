package com.jailmango.concurrence.book.action.chapter06;

import java.util.Comparator;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_2_2_接口默认方法
 *
 * @author he.gang33
 * @CreateDate 2020/11/5
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_2_2_接口默认方法 {

    private interface IHourse {

        void eat();

        default void run() {
            log.info("Hourse run...");
        }
    }

    private interface IAnimal {

        default void breath() {
            log.info("Animal breath...");
        }
    }

    private interface IDonkey {

        void eat();

        default void run() {
            log.info("Donkey run...");
        }
    }

    private static class Mule implements IHourse, IDonkey, IAnimal {

        @Override
        public void eat() {
            log.info("Mule eat...");
        }

        @Override
        public void run() {
            IDonkey.super.run();
        }
    }

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Mule mule = new Mule();
        mule.breath();
        mule.run();
        mule.eat();

        // 先比较字符换长度，再用String内部的比较器(大小写不敏感的字母顺序)进行比较
        Comparator<String> comparator = Comparator.comparingInt(String::length)
            .thenComparing(String.CASE_INSENSITIVE_ORDER);

        log.info("{}", comparator.compare("ab", "AB"));
    }
}
