package com.jailmango.concurrence.book.action.chapter05;

import lombok.extern.slf4j.Slf4j;

/**
 * C5_1_单例模式
 *
 * @author jailmango
 * @CreateDate 2020/10/20
 * @see com.jailmango.concurrence.book.action.chapter05
 * @since R9.0
 */
@Slf4j
public class C5_1_单例模式 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        log.info("end...");
    }
}

@Slf4j
class Singleton {

    private Singleton() {
        log.info("Singleton is create...");
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static Singleton instance = new Singleton();

        private SingletonHolder() {
            log.info("SingletonHolder is create...");
        }
    }
}