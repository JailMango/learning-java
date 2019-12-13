package com.jailmango.netty.lightman.netty.app.serializer.impl;

import com.alibaba.fastjson.JSON;
import com.jailmango.netty.lightman.netty.app.serializer.Serializer;
import com.jailmango.netty.lightman.netty.app.serializer.SerializerAlgorithm;

/**
 * FastJsonSerializer
 *
 * @author he.gang33
 * @CreateDate 2019/9/5
 * @see com.jailmango.netty.lightman.netty.app.serializer.impl
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
