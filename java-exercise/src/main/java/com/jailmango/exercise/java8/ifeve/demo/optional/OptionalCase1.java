package com.jailmango.exercise.java8.ifeve.demo.optional;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * OptionalCase1
 *
 * @author jailmango
 * @see com.jailmango.exercise.java8.ifeve.demo.optional
 */
@Slf4j
public class OptionalCase1 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        MsgResult r1 = null;
        MsgResult r2 = new MsgResult();
        r2.setName("r2");
        r2.setSuccess(true);

        log.info("{}", Optional.ofNullable(r1).isPresent());
        log.info("{}", Optional.ofNullable(r2).isPresent());

        log.info("{}", Optional.ofNullable(r1).filter(MsgResult::isSuccess).isPresent());
        log.info("{}", Optional.ofNullable(r2).filter(MsgResult::isSuccess).isPresent());

        log.info("{}", Optional.ofNullable(r1).filter(MsgResult::isSuccess).filter(msgResult -> StringUtils.isNotBlank(msgResult.getName())).isPresent());
        log.info("{}", Optional.ofNullable(r2).filter(MsgResult::isSuccess).filter(msgResult -> StringUtils.isNotBlank(msgResult.getName())).isPresent());
    }

    private static class MsgResult {

        private String name;

        private boolean success;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }
    }

}
