package com.jailmango.exercise.utils.random;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * RandomCase
 *
 * @author he.gang33
 * @CreateDate 2021/12/27
 * @see com.jailmango.exercise.utils.random
 */
@Slf4j
public class RandomCase {

    private static Random random = new Random();

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws InterruptedException {
        // while (true) {
        //     System.out.println();
        //     Thread.sleep(1000);
        // }

        String msg = "\n hello. \n world. \n";

        log.info("\n title:{} \n content:{}", "hello", "world");

        Map<Double, String> map = new HashMap<>();

        map.put(4.2, "4.2");
        map.put(6.8, "6.8");
        map.put(8.7, "8.7");


        Map<Double, String> truckLengthMap = ImmutableMap.<Double, String>builder()
                .put(1.8d, "1.8米")
                .put(2.7d, "2.7米")
                .put(3.8d, "3.8米")
                .put(4.2d, "4.2米")
                .put(5d, "5米")
                .put(6.2d, "6.2米")
                .put(6.8d, "6.8米")
                .put(7.7d, "7.7米")
                .put(8.2d, "8.2米")
                .put(8.7d, "8.7米")
                .put(9.6d, "9.6米")
                .put(11.7d, "11.7米")
                .put(12.5d, "12.5米")
                .put(13d, "13米")
                .put(13.7d, "13.7米")
                .put(15d, "15米")
                .put(16d, "16米")
                .put(17.5d, "17.5米")
                .build();

        List<LocalDate> list = Lists.newArrayList(LocalDate.now());
        LocalDate a = LocalDate.parse("2021-12-30");



        log.info("end...");
    }
}
