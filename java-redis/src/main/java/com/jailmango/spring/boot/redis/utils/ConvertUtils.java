package com.jailmango.spring.boot.redis.utils;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ConvertUtils
 *
 * @author he.gang33
 * @CreateDate 2019-01-30
 * @see com.jailmango.java.spring.boot.redis.utils
 * @since R9.0
 */
@Component("convertUtils")
public class ConvertUtils {

    /**
     * ObjectMapper
     */
    private ObjectMapper mapper = new ObjectMapper();

    /**
     * 将某种类型实例转换为Map
     * 
     * @param instance Object
     * @return Map<Object, Object>
     */
    public Map toMap(Object instance) {
        return mapper.convertValue(instance, Map.class);
    }

    /**
     * 将Map转换为某种类型实例
     * 
     * @param map Map<Object, Object>
     * @param type Class<T>
     * @param <T> T
     * @return <T> T
     */
    public <T> T toObject(Map<Object, Object> map, Class<T> type) {
        return mapper.convertValue(map, type);
    }
}
