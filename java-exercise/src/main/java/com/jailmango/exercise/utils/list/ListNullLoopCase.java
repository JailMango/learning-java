package com.jailmango.exercise.utils.list;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ListNullLoopCase
 *
 * @author hegang1
 * @CreateDate 2022/9/7
 * @see com.jailmango.exercise.utils.list
 */
@Slf4j
public class ListNullLoopCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<String> strList = null;

        for (String val : strList) {

        }

        log.info("end...");
    }
}
