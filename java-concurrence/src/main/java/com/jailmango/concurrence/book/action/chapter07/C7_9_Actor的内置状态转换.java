package com.jailmango.concurrence.book.action.chapter07;

import akka.actor.UntypedAbstractActor;
import akka.japi.function.Procedure;
import lombok.extern.slf4j.Slf4j;

/**
 * C7_9_Actor
 *
 * @author he.gang33
 * @CreateDate 2020/11/14
 * @see com.jailmango.concurrence.book.action.chapter07
 * @since R9.0
 */
@Slf4j
public class C7_9_Actor的内置状态转换 {

    private static class BabyActor extends UntypedAbstractActor {

        Procedure<Object> angry;

        Procedure<Object> happy;

        {
            happy = param -> {

            };

            angry = param -> {
                log.info("angryApply:{}", param);
                if (Msg.SLEEP == param) {
                    getSender().tell("I am already angry.", getSelf());
                    log.info("I am already angury.");
                }
                else if (Msg.PLAY == param) {
                    log.info("I like playing.");
                }

            };

        }

        @Override
        public void onReceive(Object message) throws Throwable, Throwable {

        }
    }

    private static enum Msg {
        SLEEP, PLAY, CLOSE
    }
}
