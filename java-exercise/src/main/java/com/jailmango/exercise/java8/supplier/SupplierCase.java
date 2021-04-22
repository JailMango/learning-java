package com.jailmango.exercise.java8.supplier;

import java.util.function.Supplier;

import lombok.extern.slf4j.Slf4j;

/**
 * SupplierCase
 *
 * @author gang.he2
 * @see com.jailmango.exercise.java8.supplier
 */
@Slf4j
public class SupplierCase {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        for (int count = 0; count < 10; count++) {
            try {
                int finalCount = count;
                calculate(() -> {
                    if (finalCount % 2 == 0) {
                        log.info("do business... count[{}]", finalCount);
                    }
                    else {
                        throw new RuntimeException("!= 0...");
                    }

                    return Boolean.TRUE;
                }, () -> {
                    throw new RuntimeException("error function catch exception...");
                });
            }
            catch (Exception e) {
                log.info("loop catch exception... count[{}]", count);
            }
        }

    }

    public static <T> T calculate(Supplier<T> busi, Supplier<Exception> exceptionHandler) throws Exception {
        try {
            return busi.get();
        }
        catch (Exception ex) {
            throw exceptionHandler.get();
        }
    }
}
