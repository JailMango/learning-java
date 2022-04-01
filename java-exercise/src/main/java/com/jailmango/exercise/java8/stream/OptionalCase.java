package com.jailmango.exercise.java8.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * OptionalCase
 *
 * @author jailmango
 * @see com.jailmango.exercise.java8.stream
 */
@Slf4j
public class OptionalCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Date now = new Date();
        log.info("now = {}", now.getTime());

        Region region = null;

        Region newRegion = Optional.ofNullable(region).orElse(new Region("region", new ArrayList<>()));

        log.info("end...");
    }

    private static class Region {

        private String name;

        private List<Integer> start;

        public Region(String name, List<Integer> start) {
            this.name = name;
            this.start = start;
        }
    }
}
