package com.jailmango.concurrence.book.action.chapter03;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_3_7_随机数据结构_跳表
 *
 * @author jailmango
 * @CreateDate 2020/10/20
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_3_7_随机数据结构_跳表 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentSkipListMap<>();

        for (int i = 0; i < 30; i++) {
            map.put(i, i);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            log.info("key[{}] value[{}]", entry.getKey(), entry.getValue());
        }
    }
}
