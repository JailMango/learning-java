package com.jailmango.exercise.utils.string;

import java.util.Random;

/**
 * StringBuilder
 *
 * @author jailmango
 * @CreateDate 2019-06-25
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class StringBuilder {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();

        sb.append(1).append(2).append(3).append(4).append(5).append(6).append(7).append(8).append(9);

        int b = 1;

        sb.delete(sb.length() - 2, sb.length());

        int a = 1;
    }
}
