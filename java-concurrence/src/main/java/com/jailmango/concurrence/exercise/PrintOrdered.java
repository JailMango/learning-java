package com.jailmango.concurrence.exercise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * PrintOrdered
 *
 * @author gang.he2
 * @CreateDate 2022/3/9
 * @see com.jailmango.concurrence.exercise
 */
public class PrintOrdered {

    private static volatile char curFlag = 'a';

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        Thread a = new Thread(new Task('a', lock, condition, 5));
        Thread b = new Thread(new Task('b', lock, condition, 5));
        Thread c = new Thread(new Task('c', lock, condition, 5));

        c.start();
        a.start();
        b.start();

    }

    private static class Task implements Runnable {

        private char word;

        private Lock lock;

        private Condition condition;


        private int loopNum;

        public Task(char word, Lock lock, Condition condition, int loopNum) {
            this.word = word;
            this.lock = lock;
            this.condition = condition;
            this.loopNum = loopNum;
        }

        @Override
        public void run() {
            for (int i = 0; i < loopNum; i++) {
                try {
                    lock.lock();
                    while (curFlag != word) {
                        condition.await();
                    }

                    System.out.println(word);
                    curFlag = (char) (curFlag == 'c' ? curFlag - 2 : curFlag + 1);
                    condition.signalAll();
                } catch (Exception e) {

                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
