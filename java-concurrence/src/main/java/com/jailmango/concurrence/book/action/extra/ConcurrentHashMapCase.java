package com.jailmango.concurrence.book.action.extra;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMapCase
 *
 * @author gang.he2
 * @CreateDate 2022/4/2
 * @see com.jailmango.concurrence.book.action.extra
 */
@Slf4j
public class ConcurrentHashMapCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();

        map.put("1", "1");
    }
}
