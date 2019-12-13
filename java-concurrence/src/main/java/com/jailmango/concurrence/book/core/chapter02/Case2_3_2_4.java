package com.jailmango.concurrence.book.core.chapter02;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case2_3_2_4 - 2.3.2 - 4. 使用Atomic原子类进行i++操作实现原子性
 *
 * @author he.gang33
 * @CreateDate 2019-05-30
 * @see com.jailmango.concurrence.book.core.chapter02
 * @since R9.0
 */
public class Case2_3_2_4 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case2_3_2_4.class);

    public static void main(String[] args) {
        Service service = new Service();

        Thread a = new Thread(service);
        a.start();
        Thread b = new Thread(service);
        b.start();
        Thread c = new Thread(service);
        c.start();
        Thread d = new Thread(service);
        d.start();
        Thread e = new Thread(service);
        e.start();

        // 本例可以看出Atomic原子类，保证了i++操作的原子性
    }

    static class Service extends Thread {

        private AtomicInteger count = new AtomicInteger(0);

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                logger.info("Thread[{}] Count = {}", Thread.currentThread().getName(), count.incrementAndGet());
            }

        }
    }

}
