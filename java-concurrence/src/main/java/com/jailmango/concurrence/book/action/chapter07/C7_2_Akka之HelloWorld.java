package com.jailmango.concurrence.book.action.chapter07;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedAbstractActor;
import lombok.extern.slf4j.Slf4j;

import com.typesafe.config.ConfigFactory;

/**
 * C7_2_Akka之HelloWorld
 *
 * @author jailmango
 * @CreateDate 2020/11/13
 * @see com.jailmango.concurrence.book.action.chapter07
 * @since R9.0
 */
@Slf4j
public class C7_2_Akka之HelloWorld {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("Hello", ConfigFactory.load("samplehello.conf"));
        ActorRef actorRef = system.actorOf(Props.create(HelloWolrd.class), "HelloWorld");
        log.info("Hello World Actor Path: {}", actorRef.path());
    }

    private static class Greeter extends UntypedAbstractActor {

        @Override
        public void onReceive(Object message) {
            if (Message.GREET == message) {
                log.info("Get Greeting...");
                log.info("Hello World...");
                getSender().tell(Message.DONE, getSelf());
            }
            else {
                log.info("Else...");
                unhandled(message);
            }
        }
    }

    private static class HelloWolrd extends UntypedAbstractActor {

        ActorRef greeter;

        @Override
        public void preStart() {
            greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
            log.info("Greeter Actor Path: {}", greeter.path());
            greeter.tell(Message.GREET, getSelf());
        }

        @Override
        public void onReceive(Object message) {
            if (Message.DONE == message) {
                log.info("Get Done...");
                greeter.tell(Message.GREET, getSelf());
                getContext().stop(getSelf());
            }
            else {
                log.info("Else...");
                unhandled(message);
            }
        }
    }

    private static enum Message {
        GREET, DONE
    }
}
