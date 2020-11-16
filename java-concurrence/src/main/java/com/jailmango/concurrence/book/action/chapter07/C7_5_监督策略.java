package com.jailmango.concurrence.book.action.chapter07;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.UntypedAbstractActor;
import lombok.extern.slf4j.Slf4j;
import scala.concurrent.duration.Duration;

import com.typesafe.config.ConfigFactory;

/**
 * C7_5_监督策略
 *
 * @author he.gang33
 * @CreateDate 2020/11/13
 * @see com.jailmango.concurrence.book.action.chapter07
 * @since R9.0
 */
@Slf4j
public class C7_5_监督策略 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("lifecycle", ConfigFactory.load("samplehello.conf"));

        ActorRef actorRef = system.actorOf(Props.create(Supervisor.class), "Supervisor");
        actorRef.tell(Props.create(RestartActor.class), ActorRef.noSender());

        ActorSelection actorSelection = system.actorSelection("akka://lifecycle/user/Supervisor/restartActor");
        for (int i = 0; i < 100; i++) {
            actorSelection.tell(Msg.RESTART, ActorRef.noSender());
        }
    }

    private static class Supervisor extends UntypedAbstractActor {

        private static SupervisorStrategy supervisorStrategy = new OneForOneStrategy(3,
            Duration.create(10, TimeUnit.SECONDS), param -> {
                if (param instanceof ArithmeticException) {
                    log.info("catch ArithmeticException, just resume...");
                    return (SupervisorStrategy.Directive) SupervisorStrategy.resume();
                }
                else if (param instanceof NullPointerException) {
                    log.info("catch NullPointerException, restart...");
                    return (SupervisorStrategy.Directive) SupervisorStrategy.restart();
                }
                else if (param instanceof IllegalArgumentException) {
                    log.info("catch IllegalArgumentException, stop...");
                    return (SupervisorStrategy.Directive) SupervisorStrategy.stop();
                }
                else {
                    return (SupervisorStrategy.Directive) SupervisorStrategy.escalate();
                }
            });

        @Override
        public SupervisorStrategy supervisorStrategy() {
            return supervisorStrategy;
        }

        @Override
        public void onReceive(Object message) {
            if (message instanceof Props) {
                getContext().actorOf((Props) message, "restartActor");
            }
            else {
                unhandled(message);
            }
        }
    }

    private static class RestartActor extends UntypedAbstractActor {

        @Override
        public void preStart() throws Exception, Exception {
            log.info("preStart, hashcode = {}...", this.hashCode());
        }

        @Override
        public void postStop() throws Exception, Exception {
            log.info("postStop, hashcode = {}...", this.hashCode());
        }

        @Override
        public void preRestart(Throwable reason, Optional<Object> message) throws Exception, Exception {
            log.info("preRestart, hashcode = {}...", this.hashCode());
        }

        @Override
        public void postRestart(Throwable reason) throws Exception, Exception {
            super.postRestart(reason);
            log.info("postRestart, hashcode = {}...", this.hashCode());
        }

        @Override
        public void onReceive(Object message) throws Throwable, Throwable {
            if (Msg.DONE == message) {
                getContext().stop(getSelf());
            }
            else if (Msg.RESTART == message) {
                log.info("Get Restart Message...");
                double a = 0 / 0;
            }
            else {
                unhandled(message);
            }
        }
    }

    private static enum Msg {
        DONE, RESTART
    }
}
