package com.jailmango.exercise.utils.string;

import com.google.common.base.Splitter;
import org.apache.commons.lang3.StringUtils;

/**
 * StringLengthUtils
 *
 * @author gang.he2
 * @CreateDate 2022/5/18
 * @see com.jailmango.exercise.utils.string
 */
public class StringLengthUtils {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String cronExpression = "0 0/3 14-16 * * ?";

        String a = formatNeteaseCronExpression(cronExpression);

        int b = 1;

        Boolean res = Boolean.TRUE;

        System.out.println(String.valueOf(res));
    }

    private static String formatNeteaseCronExpression(String cronExpression) {
        int size = Splitter.on(StringUtils.SPACE).splitToList(cronExpression).size();
        return size == 6 ? StringUtils.substring(cronExpression, 2) : cronExpression;
    }
}
