package com.jailmango.exercise.utils.localedatetime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * LocaleDateTimeCase
 *
 * @author gang.he2
 * @see com.jailmango.exercise.utils.localedatetime
 */
@Slf4j
public class LocaleDateTimeCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        log.info("now = {}", new Date().getTime());
        log.info("today = {}", LocalDateTime.of(LocalDate.of(2021, 12, 31), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        List<String> result = list.stream().filter(ele -> "3".equals(ele)).collect(Collectors.toList());

        log.info("end");
    }
}