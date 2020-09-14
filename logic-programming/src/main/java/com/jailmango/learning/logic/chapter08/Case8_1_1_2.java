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
public class Case8_1_1_2 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case8_1_1_2.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("A", 100);
        logger.info("first[{}], second[{}]", pair.getFirst(), pair.getSecond());
    }

    private static class Pair<K, V> {

        /**
         * first
         */
        K first;

        /**
         * second
         */
        V second;

        /**
         * Constructor
         * 
         * @param first K
         * @param second V
         */
        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }
}
