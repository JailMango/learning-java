package com.jailmango.concurrence.book.action.chapter04;

import java.util.concurrent.atomic.AtomicReference;

import lombok.extern.slf4j.Slf4j;

/**
 * 本例展示AtomicReference中的cas操作的缺陷(即某些场景下不符合序曲)
 *
 * @author jailmango
 * @CreateDate 2020/10/12
 * @see com.jailmango.concurrence.book.action.chapter04
 * @since R9.0
 */
@Slf4j
public class 无锁的对象引用_AtomicReference_缺陷_4_4_4 {

    static AtomicReference<Integer> money = new AtomicReference<>(19);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        // 本例模拟充值消费案例（余额小于20元时，赠送20元，且至多赠送一次）
        // 本例用于展示AtomicReference的缺陷，即无法限制至多赠送一次
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                // 模拟充值赠送线程
                while (true) {
                    while (true) {
                        Integer m = money.get();

                        if (m < 20) {
                            if (money.compareAndSet(m, m + 20)) {
                                log.info("余额小于20元，充值成功。当前余额{}元。", money.get());
                                break;
                            }
                        }
                        else {
                            log.info("余额大于20元，无须充值。");
                            break;
                        }

                        try {
                            Thread.sleep(200);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }

        new Thread(() -> {
            // 模拟消费线程
            for (int i = 0; i < 100; i++) {
                while (true) {
                    Integer m = money.get();

                    if (m > 10) {
                        log.info("大于10元。");

                        if (money.compareAndSet(m, m - 10)) {
                            log.info("成功消费10元。当前余额{}元。", money.get());
                            break;
                        }
                        else {
                            log.info("余额不足10元。");
                            break;
                        }
                    }
                }

                try {
                    Thread.sleep(200);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
