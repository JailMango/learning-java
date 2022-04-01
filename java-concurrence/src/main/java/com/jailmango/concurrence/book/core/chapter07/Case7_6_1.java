package com.jailmango.concurrence.book.core.chapter07;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 7.6.1 出现异常
 *
 * @author jailmango
 * @CreateDate 2020/9/9
 * @see com.jailmango.concurrence.book.core.chapter07
 * @since R9.0
 */
public class Case7_6_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case7_6_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateString = new String[] {
            "2020-01-01", "2020-01-02", "2020-01-03", "2020-01-04", "2020-01-05", "2020-01-06", "2020-01-07",
            "2020-01-08", "2020-01-09", "2020-01-10"
        };
        MyThread[] thread = new MyThread[10];

        for (int i = 0; i < 10; i++) {
            thread[i] = new MyThread(format, dateString[i]);
        }

        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }
    }

    private static class MyThread extends Thread {

        private SimpleDateFormat format;

        private String dateString;

        public MyThread(SimpleDateFormat format, String dateString) {
            this.format = format;
            this.dateString = dateString;
        }

        @Override
        public void run() {
            try {
                Date date = format.parse(dateString);
                String newDateString = format.format(date);

                if (!newDateString.equals(dateString)) {
                    logger.info("[{}] -> [{}]", dateString, newDateString);
                }
            }
            catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
