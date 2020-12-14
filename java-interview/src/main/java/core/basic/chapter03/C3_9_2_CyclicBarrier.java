package core.basic.chapter03;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_9_2_Barrier
 *
 * @author he.gang33
 * @CreateDate 2020/11/19
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_9_2_CyclicBarrier {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        final int count = 4;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count);

        for (int i = 0; i < count; i++) {
            new Thread(new BusinessThread(cyclicBarrier)).start();
        }

    }

    private static class BusinessThread implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public BusinessThread(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                log.info("完成准备工作...");
                Thread.sleep(2000);
                this.cyclicBarrier.await();
            }
            catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            log.info("执行下一项工作...");
        }
    }
}
