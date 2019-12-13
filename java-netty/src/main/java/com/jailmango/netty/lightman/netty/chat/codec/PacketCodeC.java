package com.jailmango.netty.lightman.netty.chat.codec;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;

import com.jailmango.netty.lightman.netty.chat.packet.Command;
import com.jailmango.netty.lightman.netty.chat.packet.Packet;
import com.jailmango.netty.lightman.netty.chat.packet.request.LoginRequestPacket;
import com.jailmango.netty.lightman.netty.chat.packet.request.MessageRequestPacket;
import com.jailmango.netty.lightman.netty.chat.packet.response.LoginResponsePacket;
import com.jailmango.netty.lightman.netty.chat.packet.response.MessageResponsePacket;
import com.jailmango.netty.lightman.netty.chat.serializer.Serializer;
import com.jailmango.netty.lightman.netty.chat.serializer.impl.FastJsonSerializer;

/**
 * PacketCodeC
 *
 * @author he.gang33
 * @CreateDate 2019-08-07
 * @see com.jailmango.netty.lightman.netty.chat.packet
 * @since R9.0
 */
public class PacketCodeC {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PacketCodeC.class);

    /**
     * PacketCodeC
     */
    public static final PacketCodeC INSTANCE = new PacketCodeC();

    /**
     * MAGIC_NUMBER
     */
    public static final int MAGIC_NUMBER = 0x12345678;

    /**
     * packetTypeMap
     */
    private final Map<Byte, Class<? extends Packet>> packetTypeMap;

    /**
     * serializerMap
     */
    private final Map<Byte, Serializer> serializerMap;

    /**
     * Constructor
     */
    public PacketCodeC() {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(Command.LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(Command.MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(Command.MESSAGE_RESPONSE, MessageResponsePacket.class);

        serializerMap = new HashMap<>();
        Serializer fastJsonSerializer = new FastJsonSerializer();
        serializerMap.put(Serializer.DEFAULT.getSerializerAlgorithm(), fastJsonSerializer);
    }

    /**
     * encode
     * 
     * @param byteBuf ByteBuf
     * @param packet Packet
     * @return ByteBuf
     */
    public ByteBuf encode(ByteBuf byteBuf, Packet packet) {
        byte[] bytes = Serializer.DEFAULT.serialize(packet);
        byteBuf.writeInt(MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);

        return byteBuf;
    }

    /**
     * decode
     * 
     * @param byteBuf ByteBuf
     * @return Packet
     */
    public Packet decode(ByteBuf byteBuf) {
        Packet retnObj = null;

        // skip magic number
        byteBuf.skipBytes(4);
        // skip version
        byteBuf.skipBytes(1);
        // serialize algorithm
        Byte serializeAlgorithm = byteBuf.readByte();
        // command
        Byte command = byteBuf.readByte();
        // length
        int length = byteBuf.readInt();
        logger.info("Data Length: [{}]", length);

        byte[] bytes = new byte[length];
        byteBuf.readBytes(bytes);

        Class<? extends Packet> packetType = getPacketType(command);
        Serializer serializer = getSerializer(serializeAlgorithm);

        if (null != packetType && null != serializer) {
            retnObj = serializer.deserialize(packetType, bytes);
        }

        return retnObj;
    }

    /**
     * getPacketType
     * 
     * @param command Byte
     * @return Class<? extends Packet>
     */
    private Class<? extends Packet> getPacketType(Byte command) {
        return packetTypeMap.get(command);
    }

    /**
     * getSerializer
     * 
     * @param serializeAlgorithm Byte
     * @return Serializer
     */
    private Serializer getSerializer(Byte serializeAlgorithm) {
        return serializerMap.get(serializeAlgorithm);
    }
}
