package com.jailmango.exercise.utils.format;

import java.math.BigDecimal;

/**
 * NumberFormat
 *
 * @author jailmango
 * @CreateDate 2022/3/2
 * @see com.jailmango.exercise.utils.format
 */
public class NumberFormat {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Double a = 0.542;

        BigDecimal bd = new BigDecimal(a);
        System.out.println(bd.setScale(2, BigDecimal.ROUND_DOWN).doubleValue());
    }
}
