package com.jailmango.exercise.utils.cas;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.BooleanUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * CasCase
 *
 * @author jailmango
 * @CreateDate 2021/9/23
 * @see com.jailmango.exercise.utils.cas
 */
@Slf4j
public class CasCase {

    private static final AtomicBoolean RUNNING = new AtomicBoolean(false);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        if (!RUNNING.compareAndSet(false, true)) {
            log.info("compareAndSet = false");
        }
        else {
            log.info("compareAndSet = true");
        }

        log.info("{}", RUNNING);

        TestClass obj = new TestClass();

        if (BooleanUtils.isNotTrue(obj.getState())) {
            log.info("not true");
        }
        else {
            log.info("not not true");
        }

        int a = 1;

        long time = LocalDateTime.of(LocalDate.now(), LocalTime.MAX).toEpochSecond(ZoneOffset.of("+8"));

        log.info("{}", time);

        //
        // for (;;) {
        //     if (ThreadLocalRandom.current().nextInt(100) < 1) {
        //         log.info("less...");
        //
        //     }
        //     else {
        //         log.info("not less...------------------");
        //     }
        //
        //     Thread.sleep(100);
        // }

        Person one = null;

        boolean suc = Optional.ofNullable(one).isPresent();
        suc = Optional.ofNullable(one).filter(Person::getState).isPresent();

        int iii = 1;

    }


    private static class TestClass {

        private Boolean state;

        public Boolean getState() {
            return state;
        }

        public void setState(Boolean state) {
            this.state = state;
        }
    }
}
