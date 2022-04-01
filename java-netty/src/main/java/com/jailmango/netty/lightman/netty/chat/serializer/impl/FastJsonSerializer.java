package com.jailmango.netty.lightman.netty.chat.serializer.impl;

import com.alibaba.fastjson.JSON;
import com.jailmango.netty.lightman.netty.chat.serializer.Serializer;
import com.jailmango.netty.lightman.netty.chat.serializer.SerializerAlgorithm;

/**
 * FastJsonSerializer
 *
 * @author jailmango
 * @CreateDate 2019-08-05
 * @see com.jailmango.netty.lightman.netty
 * @since R9.0
 */
public class FastJsonSerializer implements Serializer {

    @Override
    public Byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object obj) {
        return JSON.toJSONBytes(obj);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
