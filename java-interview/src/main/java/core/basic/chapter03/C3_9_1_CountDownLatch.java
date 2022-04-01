package core.basic.chapter03;

import java.util.concurrent.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_9_1_CountDownLatch
 *
 * @author jailmango
 * @CreateDate 2020/11/19
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_9_1_CountDownLatch {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                log.info("线程1正在执行...");
                Thread.sleep(3000);
                log.info("线程1完成...");
                countDownLatch.countDown();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                log.info("线程2正在执行...");
                Thread.sleep(4000);
                log.info("线程2完成...");
                countDownLatch.countDown();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            log.info("等待子线程执行完毕...");
            countDownLatch.await();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("end...");
    }
}
