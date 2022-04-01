package com.jailmango.concurrence.book.action.chapter03;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import lombok.extern.slf4j.Slf4j;

/**
 * C3_4_2_HelloJMH
 *
 * @author jailmango
 * @CreateDate 2020/10/20
 * @see com.jailmango.concurrence.book.action.chapter03
 * @since R9.0
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Slf4j
public class C3_4_2_HelloJMH {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder().include(C3_4_2_HelloJMH.class.getSimpleName()).forks(1).build();
        new Runner(options).run();
    }

    @Benchmark
    public void helloWorld() {

    }
}
