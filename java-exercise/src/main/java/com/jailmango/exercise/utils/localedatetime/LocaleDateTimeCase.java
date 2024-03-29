package com.jailmango.exercise.utils.localedatetime;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

/**
 * LocaleDateTimeCase
 *
 * @author jailmango
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
        TimeZone.getDefault().toZoneId();


        log.info("now = {}", new Date().getTime());
        log.info("today = {}", LocalDateTime.of(LocalDate.of(2021, 12, 31), LocalTime.MAX).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        List<String> result = list.stream().filter(ele -> "3".equals(ele)).collect(Collectors.toList());


        LocalDateTime time = LocalDateTime.now(TimeZone.getDefault().toZoneId());



        Date a = Date.from(LocalDateTime.of(2015, 1,1, 0, 0 ,0).toInstant(ZoneOffset.of("+8")));

        log.info("end");
    }
}