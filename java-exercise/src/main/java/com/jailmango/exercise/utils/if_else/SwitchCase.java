package com.jailmango.exercise.utils.if_else;

import lombok.extern.slf4j.Slf4j;

/**
 * SwitchCase
 *
 * @author jailmango
 * @CreateDate 2021/11/30
 * @see com.jailmango.exercise.utils.if_else
 */
@Slf4j
public class SwitchCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String str = null;
        switch (str) {
            case "1":
                log.info("1");
            default:
                log.info("null");
        }
    }
}
