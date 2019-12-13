package com.jailmango.netty.lightman.netty.chat.bytebuf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

/**
 * ByteBufInfo
 *
 * @author he.gang33
 * @CreateDate 2019-08-05
 * @see com.jailmango.netty.lightman.netty
 * @since R9.0
 */
public class ByteBufInfo {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ByteBufInfo.class);

    /**
     * getByteBufInfo
     *
     * @param byteBuf ByteBuf
     */
    public static void getByteBufInfo(ByteBuf byteBuf) {
        logger.info("--------------- ByteBuf Info ---------------");
        logger.info("Client ByteBuf isReadable: [{}]", byteBuf.isReadable());
        logger.info("Client ByteBuf readableBytes: [{}]", byteBuf.readableBytes());
        logger.info("Client ByteBuf capacity: [{}]", byteBuf.capacity());
        logger.info("Client ByteBuf maxCapacity: [{}]", byteBuf.maxCapacity());
        logger.info("Client ByteBuf isWritable: [{}]", byteBuf.isWritable());
        logger.info("Client ByteBuf writableBytes: [{}]", byteBuf.writableBytes());
        logger.info("Client ByteBuf maxWritableBytes: [{}]", byteBuf.maxWritableBytes());
        logger.info("Client ByteBuf readerIndex: [{}]", byteBuf.readerIndex());
        logger.info("Client ByteBuf writerIndex: [{}]", byteBuf.writerIndex());
        logger.info("--------------------------------------------");
    }

    public static void getByteBufInfo(String action, ByteBuf byteBuf) {
        logger.info("--------------- {} ---------------", action);
        getByteBufInfo(byteBuf);
    }

    public static void main(String[] args) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(9, 100);
        getByteBufInfo("ByteBufAllocator.DEFAULT.buffer(9, 100)", byteBuf);

        // write()方法改变写指针，写完之后，若写指针还未到capacity，则ByteBuf仍可写
        byteBuf.writeBytes(new byte[] {
            1, 2, 3, 4
        });
        getByteBufInfo("byteBuf.writeBytes(new byte[] {1, 2, 3, 4})", byteBuf);

        // int型占4个字节，写完仍未到capacity，因此ByteBuf仍然可写1个字节
        byteBuf.writeInt(12);
        getByteBufInfo("byteBuf.writeInt(4)", byteBuf);

        // write 方法改变写指针, 写完之后写指针等于 capacity 的时候，buffer 不可写
        byteBuf.writeBytes(new byte[] {
            5
        });
        getByteBufInfo("byteBuf.writeBytes(new byte[] {5})", byteBuf);

        // write 方法改变写指针，写的时候发现 buffer 不可写则开始扩容，扩容之后 capacity 随即改变
        byteBuf.writeBytes(new byte[] {
            6
        });
        getByteBufInfo("byteBuf.writeBytes(new byte[] {6})", byteBuf);

        // get 方法不改变读写指针
        logger.info("byteBuf.getByte(3) -> {}", byteBuf.getByte(3));
        logger.info("byteBuf.getShort(3) -> {}", byteBuf.getShort(3));
        logger.info("byteBuf.getInt(3) -> {}", byteBuf.getInt(3));
        getByteBufInfo("byteBuf.getByte()", byteBuf);

        // set 方法不改变读写指针
        byteBuf.setByte(byteBuf.readableBytes() + 1, 0);
        getByteBufInfo("byteBuf.setByte(byteBuf.readableBytes() + 1, 0)", byteBuf);

        // read 方法改变读指针
        byte[] dst = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(dst);
        getByteBufInfo("byteBuf.readBytes(" + dst.length + ")", byteBuf);
    }
}
