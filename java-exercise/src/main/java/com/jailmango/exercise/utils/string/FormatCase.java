package com.jailmango.exercise.utils.string;

/**
 * FormatCase
 *
 * @author he.gang33
 * @CreateDate 2020/7/17
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
public class FormatCase {

    public static void main(String[] args) {
        String tmp = "%s = %s";

        System.out.println(String.format(tmp, "1", "2"));
    }
}
