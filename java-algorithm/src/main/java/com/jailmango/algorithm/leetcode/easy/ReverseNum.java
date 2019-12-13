package com.jailmango.algorithm.leetcode.easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ReverseNum - leetcode #7
 *
 * @author he.gang33
 * @CreateDate 2019-03-25
 * @see com.jailmango.algorithm.leetcode.easy
 * @since R9.0
 */
public class ReverseNum {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ReverseNum.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ReverseNum ins = new ReverseNum();
        logger.info(String.valueOf(ins.reverse(1534236469)));
    }

    public int reverse(int x) {
        int rev = 0;

        while (x != 0) {
            int pop = x % 10;
            x /= 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;
    }
}
