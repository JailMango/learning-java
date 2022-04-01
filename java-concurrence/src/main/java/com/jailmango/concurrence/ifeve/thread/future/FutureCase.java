package com.jailmango.concurrence.ifeve.thread.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FutureCase
 *
 * @author jailmango
 * @CreateDate 2019-04-30
 * @see com.jailmango.concurrence.ifeve.thread.future
 * @since R9.0
 */
public class FutureCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FutureCase.class);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        // Online Shopping
        logger.info("Order tools in JD...");
        Callable<Tools> onlineShopping = () -> {
            logger.info("1st Step: Order...");
            logger.info("2nd Step: Waiting...");
            Thread.sleep(20000);
            logger.info("3rd Step: Arrive...");
            return new Tools("Tools");
        };
        FutureTask<Tools> task = new FutureTask<>(onlineShopping);
        new Thread(task, "OnlineShopping-Thread").start();

        // Buy Foods
        logger.info("buy foods start...");
        logger.info("buying...");
        Thread.sleep(2000);
        Foods foods = new Foods("Foods");
        logger.info("buy foods end...");

        if (!task.isDone()) {
            logger.info("Contact JD...");
        }

        // get()方法是阻塞的
        Tools tools = task.get();
        logger.info("Recevive tools...");

        cook(tools, foods);

        long endTime = System.currentTimeMillis();
        logger.info("Cost: [{}]ms", startTime - endTime);
    }

    private static void cook(Tools tools, Foods foods) {
        logger.info("Using {} cook {}", tools.getName(), foods.getName());
    }

    static class Tools {

        /**
         * name
         */
        private String name;

        public Tools(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Foods {

        /**
         * name
         */
        private String name;

        public Foods(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
