package com.jailmango.netty.lightman.netty.app.serializer;

import com.jailmango.netty.lightman.netty.app.serializer.impl.FastJsonSerializer;

/**
 * Serializer
 *
 * @author jailmango
 * @CreateDate 2019/9/5
 * @see com.jailmango.netty.lightman.netty.app.serializer
 * @since R9.0
 */
public interface Serializer {

    /**
     * DEFAULT
     */
    Serializer DEFAULT = new FastJsonSerializer();

    /**
     * 获取序列化算法
     * 
     * @return Byte
     */
    Byte getSerializerAlgorithm();

    /**
     * 序列化
     * 
     * @param obj Object
     * @return byte[]
     */
    byte[] serialize(Object obj);

    /**
     * 反序列化
     * 
     * @param clazz Class<T>
     * @param bytes byte[]
     * @param <T> T
     * @return <T> T
     */
    <T> T deserialize(Class<T> clazz, byte[] bytes);
}
