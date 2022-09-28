package com.jailmango.exercise.utils.uuid;

import lombok.extern.slf4j.Slf4j;

/**
 * UUID
 *
 * @author hegang1
 * @CreateDate 2022/8/18
 * @see com.jailmango.exercise.utils.uuid
 */
@Slf4j
public class UUID {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        String uuid = java.util.UUID.randomUUID().toString();

        log.info("{}", uuid);
    }
}
