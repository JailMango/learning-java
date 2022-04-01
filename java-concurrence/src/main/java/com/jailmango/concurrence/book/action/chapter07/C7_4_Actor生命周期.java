package com.jailmango.concurrence.book.action.chapter07;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.PoisonPill;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.actor.UntypedAbstractActor;
import lombok.extern.slf4j.Slf4j;

import com.typesafe.config.ConfigFactory;

/**
 * C7_4_Actor生命周期
 *
 * @author jailmango
 * @CreateDate 2020/11/13
 * @see com.jailmango.concurrence.book.action.chapter07
 * @since R9.0
 */
@Slf4j
public class C7_4_Actor生命周期 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("deadwatch", ConfigFactory.load("samplehello.conf"));
        ActorRef worker = system.actorOf(Props.create(Worker.class), "worker");
        system.actorOf(Props.create(Watcher.class, worker), "watcher");
        worker.tell(Msg.WORKING, ActorRef.noSender());
        worker.tell(Msg.DONE, ActorRef.noSender());
        worker.tell(PoisonPill.getInstance(), ActorRef.noSender());
    }

    private static class Worker extends UntypedAbstractActor {

        @Override
        public void preStart() throws Exception, Exception {
            log.info("Worker is starting...");
        }

        @Override
        public void postStop() throws Exception, Exception {
            log.info("Worker is stoping...");
        }

        @Override
        public void onReceive(Object message) throws Throwable, Throwable {
            if (Msg.WORKING == message) {
                log.info("I'm working...");
            }

            if (Msg.DONE == message) {
                log.info("Stop working...");
            }

            if (Msg.CLOSE == message) {
                log.info("I will shutdown...");
                getSender().tell(Msg.CLOSE, getSelf());
                getContext().stop(getSelf());
            }
            else {
                unhandled(message);
            }
        }
    }

    private static class Watcher extends UntypedAbstractActor {

        public Watcher(ActorRef actorRef) {
            getContext().watch(actorRef);
        }

        @Override
        public void onReceive(Object message) throws Throwable, Throwable {
            if (message instanceof Terminated) {
                log.info("{} has terminated, shutting down system...", ((Terminated) message).getActor().path());
                getContext().system().terminate();
            }
            else {
                unhandled(message);
            }
        }
    }

    private static enum Msg {
        WORKING, DONE, CLOSE
    }
}
