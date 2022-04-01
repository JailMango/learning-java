package com.jailmango.exercise.utils.date;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CalendaUtils
 *
 * @author jailmango
 * @CreateDate 2019-02-12
 * @see com.jailmango.exercise.utils.date
 * @since R9.0
 */
public class CalendaUtils {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CalendaUtils.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        Calendar instance = Calendar.getInstance();

        Date before = instance.getTime();
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            logger.error(e.getLocalizedMessage());
        }
        int firstDayOfWeek = instance.getFirstDayOfWeek();
        instance.add(Calendar.HOUR, 1);
        Date after = instance.getTime();

        boolean b1 = before.before(after);
        boolean b2 = before.after(after);

        logger.info("CalendaUtils end...");


        Date begin = new Date();
        Thread.sleep(1000);
        Date end = new Date();

        System.out.println(begin.compareTo(end));
    }
}
