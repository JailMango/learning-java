package com.jailmango.concurrence.book.action.chapter06;

import java.util.stream.IntStream;

import lombok.extern.slf4j.Slf4j;

/**
 * C6_4_1_使用并行流过滤
 *
 * @author he.gang33
 * @CreateDate 2020/11/10
 * @see com.jailmango.concurrence.book.action.chapter06
 * @since R9.0
 */
@Slf4j
public class C6_4_1_使用并行流过滤 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        long count = IntStream.range(1, 100000).filter(PrimeUtil::isPrime).count();
        long end = System.currentTimeMillis();
        log.info("Count = {}, Cost = {}", count, end - begin);

        // 并行流
        long begin1 = System.currentTimeMillis();
        long count1 = IntStream.range(1, 100000).parallel().filter(PrimeUtil::isPrime).count();
        long end1 = System.currentTimeMillis();
        log.info("Count = {}, Cost = {}", count1, end1 - begin1);
    }

    private static class PrimeUtil {

        public static boolean isPrime(int number) {
            int tmp = number;

            if (tmp < 2) {
                return false;
            }

            for (int i = 2; Math.sqrt(tmp) >= i; i++) {
                if (tmp % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
