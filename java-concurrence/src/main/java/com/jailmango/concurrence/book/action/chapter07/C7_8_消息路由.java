package com.jailmango.concurrence.book.action.chapter07;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.actor.UntypedAbstractActor;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;
import lombok.extern.slf4j.Slf4j;

/**
 * C7_8_消息路由
 *
 * @author jailmango
 * @CreateDate 2020/11/14
 * @see com.jailmango.concurrence.book.action.chapter07
 * @since R9.0
 */
@Slf4j
public class C7_8_消息路由 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

    }

    private static class WatchActor extends UntypedAbstractActor {

        public Router router;

        {
            List<Routee> routees = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                ActorRef worker = getContext().actorOf(Props.create(MyWorker.class), "worker_" + i);
                getContext().watch(worker);
                routees.add(new ActorRefRoutee(worker));
            }

            router = new Router(new RoundRobinRoutingLogic(), routees);
        }

        @Override
        public void onReceive(Object message) throws Throwable, Throwable {
            if (message instanceof MyWorker.Msg) {
                router.route(message, getSender());
            }
            else if (message instanceof Terminated) {
                router = router.removeRoutee(((Terminated) message).actor());
                log.info("{} is closed, routees = {}", ((Terminated) message).actor().path(), router.routees().size());

                if (router.routees().size() == 0) {
                    log.info("Close system...");
                    getContext().system().terminate();
                }
            }
            else {
                unhandled(message);
            }
        }
    }

    private static class MyWorker extends UntypedAbstractActor {

        private static enum Msg {
            WORKING, DONE, CLOSE
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
