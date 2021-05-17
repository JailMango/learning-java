package com.jailmango.exercise.java8.ifeve.demo;

import java.util.function.Supplier;

/**
 * InfiniteLoopUtil
 *
 * @author gang.he2
 * @see com.jailmango.exercise.java8.ifeve.demo
 */
public final class InfiniteLoopUtil {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Long id = 965006065496341656L;

        Long result = id % 64;

        System.out.println("...");
    }

    public static <T> void doBiz(Supplier<T> bizTask, Supplier<Boolean> judgeTask) {
        while (Boolean.TRUE.equals(judgeTask.get())) {
            bizTask.get();
        }
    }
}
