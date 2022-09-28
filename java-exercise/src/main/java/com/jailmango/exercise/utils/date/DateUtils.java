package com.jailmango.exercise.utils.date;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * DateUtils
 *
 * @author jailmango
 * @CreateDate 2021/2/1
 * @see com.jailmango.exercise.utils.date
 * @since R9.0
 */
@Slf4j
public class DateUtils {

    private static DateFormat dateFormat = SimpleDateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Date early = new Date(0L);

        Date date = new Date(1612170180000L);
        long value = date.getTime();

        // 1612 1701 8000 0

        log.info("{}", dateFormat.format(new Date()));

        LocalDateTime today_00 = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);
        Instant ins = today_00.toInstant(ZoneOffset.of("+8"));
        Instant nextIns = ins.plus(1, ChronoUnit.DAYS);


        ins.plusSeconds(ChronoUnit.DAYS.getDuration().getSeconds());


        log.info("today: {}", ins.getEpochSecond());
        log.info("next day: {}", nextIns.getEpochSecond());



        log.info("end...");
    }
}
