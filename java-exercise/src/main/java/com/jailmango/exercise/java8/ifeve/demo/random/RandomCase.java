package com.jailmango.exercise.java8.ifeve.demo.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * RandomCase
 *
 * @author jailmango
 * @CreateDate 2022/1/12
 * @see com.jailmango.exercise.java8.ifeve.demo.random
 */
public class RandomCase {

    public static void main(String[] args) {
        for (; ; ) {
            System.out.println(ThreadLocalRandom.current().nextInt(0, 5));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
