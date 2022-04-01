package com.jailmango.exercise.utils.list;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * ListPartitionCase
 *
 * @author jailmango
 * @CreateDate 2021/11/2
 * @see com.jailmango.exercise.utils.list
 */
@Slf4j
public class ListPartitionCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("1", "2", "3");

        List<List<String>> part = Lists.partition(list, 2);

        log.info("end...");
    }
}
