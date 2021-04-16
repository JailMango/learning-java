package com.jailmango.exercise.utils.date;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;

/**
 * DateUtils
 *
 * @author he.gang33
 * @CreateDate 2021/2/1
 * @see com.jailmango.exercise.utils.date
 * @since R9.0
 */
@Slf4j
public class DateUtils {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Date early = new Date(0L);

        Date now = new Date(1612170180000L);
        long value = now.getTime();

        log.info("end...");
    }
}
