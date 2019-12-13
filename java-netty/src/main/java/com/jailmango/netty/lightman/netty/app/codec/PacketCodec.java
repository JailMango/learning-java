package com.jailmango.netty.lightman.netty.app.codec;

import java.util.HashMap;
import java.util.Map;

import io.netty.buffer.ByteBuf;

import com.jailmango.netty.lightman.netty.app.constant.ProtocolConstant;
import com.jailmango.netty.lightman.netty.app.packet.Packet;
import com.jailmango.netty.lightman.netty.app.packet.command.Command;
import com.jailmango.netty.lightman.netty.app.packet.request.CreateGroupRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.request.GroupMessageRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.request.JoinGroupRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.request.ListGroupMembersRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.request.LoginRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.request.LogoutRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.request.MessageRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.request.QuitGroupRequestPacket;
import com.jailmango.netty.lightman.netty.app.packet.response.CreateGroupResponsePacket;
import com.jailmango.netty.lightman.netty.app.packet.response.GroupMessageResponsePacket;
import com.jailmango.netty.lightman.netty.app.packet.response.JoinGroupResponsePacket;
import com.jailmango.netty.lightman.netty.app.packet.response.ListGroupMembersResposnePacket;
import com.jailmango.netty.lightman.netty.app.packet.response.LoginResponsePacket;
import com.jailmango.netty.lightman.netty.app.packet.response.LogoutResponsePacket;
import com.jailmango.netty.lightman.netty.app.packet.response.MessageResponsePacket;
import com.jailmango.netty.lightman.netty.app.packet.response.QuitGroupResponsePacket;
import com.jailmango.netty.lightman.netty.app.serializer.Serializer;
import com.jailmango.netty.lightman.netty.app.serializer.SerializerAlgorithm;
import com.jailmango.netty.lightman.netty.app.serializer.impl.FastJsonSerializer;

/**
 * PacketCodeC
 *
 * @author he.gang33
 * @CreateDate 2019/9/5
 * @see com.jailmango.netty.lightman.netty.app.codec
 * @since R9.0
 */
public enum PacketCodec {

    /**
     * INSTANCE
     */
    INSTANCE;

    /**
     * packetTypeMap
     */
    private final Map<Byte, Class<? extends Packet>> packetTypeMap;

    /**
     * serializerMap
     */
    private final Map<Byte, Serializer> serializerMap;

    PacketCodec() {
        packetTypeMap = new HashMap<>();
        packetTypeMap.put(Command.LOGIN_REQUEST, LoginRequestPacket.class);
        packetTypeMap.put(Command.LOGIN_RESPONSE, LoginResponsePacket.class);
        packetTypeMap.put(Command.MESSAGE_REQUEST, MessageRequestPacket.class);
        packetTypeMap.put(Command.MESSAGE_RESPONSE, MessageResponsePacket.class);
        packetTypeMap.put(Command.CREATE_GROUP_REQUEST, CreateGroupRequestPacket.class);
        packetTypeMap.put(Command.CREATE_GROUP_RESPONSE, CreateGroupResponsePacket.class);
        packetTypeMap.put(Command.JOIN_GROUP_REQUEST, JoinGroupRequestPacket.class);
        packetTypeMap.put(Command.JOIN_GROUP_RESPONSE, JoinGroupResponsePacket.class);
        packetTypeMap.put(Command.QUIT_GROUP_REQUEST, QuitGroupRequestPacket.class);
        packetTypeMap.put(Command.QUIT_GROUP_RESPONSE, QuitGroupResponsePacket.class);
        packetTypeMap.put(Command.LIST_GROUP_MEMBERS_REQUEST, ListGroupMembersRequestPacket.class);
        packetTypeMap.put(Command.LIST_GROUP_MEMBERS_RESPONSE, ListGroupMembersResposnePacket.class);
        packetTypeMap.put(Command.GROUP_MESSAGE_REQUEST, GroupMessageRequestPacket.class);
        packetTypeMap.put(Command.GROUP_MESSAGE_RESPONSE, GroupMessageResponsePacket.class);
        packetTypeMap.put(Command.LOGOUT_REQUEST, LogoutRequestPacket.class);
        packetTypeMap.put(Command.LOGOUT_RESPONSE, LogoutResponsePacket.class);

        serializerMap = new HashMap<>();
        serializerMap.put(SerializerAlgorithm.JSON, new FastJsonSerializer());
    }

    /**
     * 编码
     *
     * @param byteBuf ByteBuf
     * @param packet Packet
     */
    public void encode(ByteBuf byteBuf, Packet packet) {
        // 序列化对象
        byte[] bytes = Serializer.DEFAULT.serialize(packet);

        byteBuf.writeInt(ProtocolConstant.MAGIC_NUMBER);
        byteBuf.writeByte(packet.getVersion());
        byteBuf.writeByte(Serializer.DEFAULT.getSerializerAlgorithm());
        byteBuf.writeByte(packet.getCommand());
        byteBuf.writeInt(bytes.length);
        byteBuf.writeBytes(bytes);
    }

    /**
     * 解码
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
        // data length
        int length = byteBuf.readInt();
        // data
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
     * 根据指令获取消息类型
     *
     * @param command Byte
     * @return Class<? extends Packet>
     */
    private Class<? extends Packet> getPacketType(Byte command) {
        return packetTypeMap.get(command);
    }

    /**
     * 获取序列化器
     *
     * @param serializeAlgorithm Byte
     * @return Serializer
     */
    private Serializer getSerializer(Byte serializeAlgorithm) {
        return serializerMap.get(serializeAlgorithm);
    }
}
