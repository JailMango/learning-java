package com.jailmango.exercise.utils.page;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * PageUtils
 *
 * @author hegang1
 * @CreateDate 2022/7/5
 * @see com.jailmango.exercise.utils.page
 */
@Slf4j
public class PageUtils {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                log.info("input total.");
                int total = scanner.nextInt();

                log.info("input page size.");
                int pageSize = scanner.nextInt();

                // int result = total / pageSize;

                int result = (total + pageSize - 1) / pageSize;

                // if (total % pageSize != 0) {
                //     result++;
                // }

                log.info("{}", result);
            }
        }

    }
}
