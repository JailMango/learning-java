package com.jailmango.concurrence.book.core.chapter06;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case6_2_5_1 - 有可能发生指令重排
 *
 * @author he.gang33
 * @CreateDate 2020/8/24
 * @see com.jailmango.concurrence.book.core.chapter06
 * @since R9.0
 */
public class Case6_2_5_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case6_2_5_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        for (;;) {
            CountDownLatch latch = new CountDownLatch(1);
            CountDownLatch end = new CountDownLatch(100);

            for (int i = 0; i < 100; i++) {
                Thread thread = new Thread(() -> {
                    try {
                        latch.await();
                        OneInstanceService one = OneInstanceService.getInstance();

                        if (one.i_am_has_state == 0) {
                            logger.info("{}", "one.i_am_has_state == 0 进程结束");
                            System.exit(0);
                        }

                        end.countDown();
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
            }

            latch.countDown();
            end.await();
            OneInstanceService.reset();
        }
    }

    private static class OneInstanceService {

        public int i_am_has_state = 0;

        private static OneInstanceService instance;

        private OneInstanceService() {
            i_am_has_state = new Random().nextInt() + 1;
        }

        public static OneInstanceService getInstance() {
            if (null == instance) {
                synchronized (OneInstanceService.class) {
                    if (null == instance) {
                        instance = new OneInstanceService();
                    }
                }
            }

            return instance;
        }

        public static void reset() {
            instance = null;
        }
    }
}
