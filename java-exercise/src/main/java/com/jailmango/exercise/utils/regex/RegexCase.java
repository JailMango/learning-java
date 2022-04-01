package com.jailmango.exercise.utils.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RegexCase
 *
 * @author jailmango
 * @CreateDate 2019-05-15
 * @see com.jailmango.exercise.utils.regex
 * @since R9.0
 */
public class RegexCase {

    /**
     * main
     * 
     * @param args String[]
     */
    public static void main(String[] args) {
        String input = "201902";
        String regex = "^(20[0-9][0-9])(0[1-9]|1[0-2])$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        if (matcher.matches()) {
            System.out.println(true);
        }
        else {
            System.out.println(false);
        }
    }
}
