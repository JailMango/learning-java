package com.jailmango.learning.logic.chapter08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 8.1.1 一个简单泛型类
 *
 * @author he.gang33
 * @CreateDate 2020/8/6
 * @see com.jailmango.learning.logic.chapter08
 * @since R9.0
 */
public class Case8_1_1_1 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case8_1_1_1.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Pair<String> pair1 = new Pair<>("A", "B");
        logger.info("first[{}], second[{}]", pair1.getFirst(), pair1.getSecond());

        Pair<Integer> pair2 = new Pair<>(1, 2);
        logger.info("first[{}], second[{}]", pair2.getFirst(), pair2.getSecond());
    }

    private static class Pair<T> {

        /**
         * first
         */
        T first;

        /**
         * second
         */
        T second;

        /**
         * Constructor
         * 
         * @param first T
         * @param second T
         */
        public Pair(T first, T second) {
            this.first = first;
            this.second = second;
        }

        public T getFirst() {
            return first;
        }

        public void setFirst(T first) {
            this.first = first;
        }

        public T getSecond() {
            return second;
        }

        public void setSecond(T second) {
            this.second = second;
        }
    }
}
