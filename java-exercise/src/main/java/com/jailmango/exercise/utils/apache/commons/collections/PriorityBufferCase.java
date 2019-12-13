package com.jailmango.exercise.utils.apache.commons.collections;

import java.util.Random;

import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.buffer.PriorityBuffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.exercise.utils.comparator.UserComparator;
import com.jailmango.exercise.utils.comparator.UserDto;

/**
 * PriorityBufferCase - 可以按照优先级高低，输出的数据结构，先拿到优先级高的数据
 *
 * @author he.gang33
 * @CreateDate 2019-06-26
 * @see com.jailmango.exercise.utils.apache.commons.collections
 * @since R9.0
 */
public class PriorityBufferCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PriorityBufferCase.class);

    private static final int LOOP_SIZE = 10;

    public static void main(String[] args) {
        Buffer buffer = new PriorityBuffer(new UserComparator());
        Random random = new Random();
        UserDto user;

        for (int i = 0; i < LOOP_SIZE; i++) {
            user = new UserDto(random.nextInt(100));
            buffer.add(user);
            logger.info("Add user[{}] into buffer.", user.getAge());
        }

        logger.info("===================================================");

        for (int i = 0; i < LOOP_SIZE; i++) {
            user = (UserDto) buffer.remove();
            logger.info("Get user [{}] from buffer.", user.getAge());
        }
    }
}
