package com.jailmango.concurrence.book.action.chapter04;

import java.util.concurrent.atomic.AtomicStampedReference;

import lombok.extern.slf4j.Slf4j;

/**
 * 无锁的对象引用_AtomicStampedReference_4_4_5
 *
 * @author he.gang33
 * @CreateDate 2020/10/12
 * @see com.jailmango.concurrence.book.action.chapter04
 * @since R9.0
 */
@Slf4j
public class 无锁的对象引用_AtomicStampedReference_4_4_5 {

    static AtomicStampedReference<Integer> money = new AtomicStampedReference<>(19, 0);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        // 本例模拟充值消费案例（余额小于20元时，赠送20元，且至多赠送一次）
        // 本例用于展示AtomicReference的缺陷，即无法限制至多赠送一次
        for (int i = 0; i < 3; i++) {
            final int timestamp = money.getStamp();
            new Thread(() -> {
                int count = 0;
                // 模拟充值赠送线程
                while (true) {
                    while (true) {
                        Integer m = money.getReference();

                        if (m < 20) {
                            if (money.compareAndSet(m, m + 20, timestamp, timestamp + 1)) {
                                log.info("余额小于20元，充值成功。当前余额{}元。", money.getReference());
                                break;
                            }
                        }
                        else {
                            count++;

                            if (count > 50) {
                                count = 0;
                                log.info("余额大于20元，无须充值。");
                            }
                            break;
                        }
                    }

                    try {
                        Thread.sleep(10);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        new Thread(() -> {
            // 模拟消费线程
            for (int i = 0; i < 100; i++) {
                int count = 0;
                while (true) {
                    int timestamp = money.getStamp();
                    Integer m = money.getReference();

                    if (m > 10) {
                        log.info("大于10元。");

                        if (money.compareAndSet(m, m - 10, timestamp, timestamp + 1)) {
                            log.info("成功消费10元。当前余额{}元。", money.getReference());
                            break;
                        }
                    }
                    else {
                        count++;
                        if (count > 50) {
                            count = 0;
                            log.info("余额不足10元。");
                        }
                        break;
                    }
                }

                try {
                    Thread.sleep(10);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
