package core.basic.chapter03;

import java.util.concurrent.Semaphore;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_6_7_Semaphore信号量
 *
 * @author jailmango
 * @CreateDate 2020/11/18
 * @see core.basic.chapter03
 * @since R9.0
 */
@Slf4j
public class C3_6_7_Semaphore信号量 {

    private static Semaphore semaphore = new Semaphore(3);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    log.info("doing...");
                    Thread.sleep(2000);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    semaphore.release();
                }
            }).start();
        }
    }
}
