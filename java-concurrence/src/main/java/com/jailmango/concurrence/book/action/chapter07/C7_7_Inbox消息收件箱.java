package com.jailmango.concurrence.book.action.chapter07;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import lombok.extern.slf4j.Slf4j;

import com.typesafe.config.ConfigFactory;

/**
 * C7_7_Inbox消息收件箱
 *
 * @author he.gang33
 * @CreateDate 2020/11/14
 * @see com.jailmango.concurrence.book.action.chapter07
 * @since R9.0
 */
@Slf4j
public class C7_7_Inbox消息收件箱 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("inboxdemo", ConfigFactory.load("samplehello.conf"));
        ActorRef worker = system.actorOf(Props.create(MyWorker.class), "worker");

    }

    private static class MyWorker extends UntypedAbstractActor {

        private static enum Msg {
            WORKING, DONE, CLOSE;
        }

        @Override
        public void onReceive(Object message) throws Throwable, Throwable {
            if (Msg.WORKING == message) {
                log.info("working...");
            }
            else if (Msg.DONE == message) {
                log.info("stop working...");
            }
            else if (Msg.CLOSE == message) {
                log.info("i will shutdown...");
                getSender().tell(Msg.CLOSE, getSelf());
                getContext().stop(getSelf());
            }
            else {
                unhandled(message);
            }
        }
    }
}
