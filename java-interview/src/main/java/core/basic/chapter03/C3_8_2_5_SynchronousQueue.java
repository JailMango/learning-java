package core.basic.chapter03;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_8_2_5_SynchronousQueue
 *
 * @author jailmango
 * @CreateDate 2020/11/18
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_8_2_5_SynchronousQueue {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        log.info("start...");
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        new Thread(new Consumer(queue)).start();
        new Thread(new Producer(queue)).start();

    }

    private static class Producer implements Runnable {

        private SynchronousQueue<Integer> queue;

        public Producer(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int product = new Random().nextInt(1000);
                    queue.put(product);
                    log.info("produce a product[{}]", product);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.info("Producer -> queue is empty: {}", queue.isEmpty());
            }
        }
    }

    private static class Consumer implements Runnable {

        private SynchronousQueue<Integer> queue;

        public Consumer(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int product = queue.take();
                    log.info("consume a product[{}]", product);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Consumer -> queue is empty: {}", queue.isEmpty());
            }
        }
    }

}
