package com.jailmango.netty.lightman.netty.app.packet;

import lombok.Data;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Packet
 *
 * @author jailmango
 * @CreateDate 2019/9/3
 * @see com.jailmango.netty.lightman.netty.app.packet
 * @since R9.0
 */
@Data
public abstract class Packet {

    /**
     * version
     */
    @JSONField(deserialize = false, serialize = false)
    private Byte version = 1;

    /**
     * 获取指令
     * 
     * @return Byte
     */
    @JSONField(serialize = false)
    public abstract Byte getCommand();
}
