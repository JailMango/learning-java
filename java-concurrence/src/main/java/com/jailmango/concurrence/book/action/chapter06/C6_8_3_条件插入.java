package com.jailmango.concurrence.book.action.chapter06;

import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_8_3_条件插入
 *
 * @author he.gang33
 * @CreateDate 2020/11/12
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_8_3_条件插入 {

    private static class HeavyObject {

        public HeavyObject() {
            log.info("HeavyObject created...");
        }
    }

    /**
     * 传统写法
     * 
     * @param map ConcurrentHashMap<String, HeavyObject>
     * @param key String
     * @return HeavyObject
     */
    public static HeavyObject getOrCreate(ConcurrentHashMap<String, HeavyObject> map, String key) {
        HeavyObject value = map.get(key);

        if (value == null) {
            value = new HeavyObject();
            map.put(key, value);
        }

        return value;
    }

    public static HeavyObject getOrCreateBetter(ConcurrentHashMap<String, HeavyObject> map, String key) {
        return map.computeIfAbsent(key, s -> new HeavyObject());
    }
}
