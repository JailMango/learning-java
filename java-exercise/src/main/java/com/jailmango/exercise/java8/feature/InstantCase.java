package com.jailmango.exercise.java8.feature;

import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

/**
 * InstantCase
 *
 * @author gang.he2
 * @see com.jailmango.exercise.java8.feature
 */
@Slf4j
public class InstantCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        log.info("时间原点 = {}", Instant.EPOCH);
        log.info("时间最大值 = {}", Instant.MAX);
    }
}
