package com.jailmango.concurrence.book.core.chapter01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_7 - 1.7 getStackTrace()
 *
 * @author jailmango
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_7 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_7.class);

    public static void main(String[] args) {

    }

    public static void getStackTrace() {
        MyThread ins = new MyThread();
        ins.a();
    }

    public static void dumpStack() {
        MyThread ins = new MyThread();
        ins.method1();
    }

    static class MyThread {

        public void a() {
            b();
        }

        public void b() {
            c();
        }

        public void c() {
            d();
        }

        public void d() {
            e();
        }

        public void e() {
            StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

            if (null != stackTraceElements && 0 != stackTraceElements.length) {
                for (int index = 0; index < stackTraceElements.length; index++) {
                    StackTraceElement stackTraceElement = stackTraceElements[index];
                    logger.info("Class: [{}], Method: [{}], File: [{}], Line: [{}], Is native method: [{}]",
                        stackTraceElement.getClassName(), stackTraceElement.getMethodName(),
                        stackTraceElement.getFileName(), stackTraceElement.getLineNumber(),
                        stackTraceElement.isNativeMethod());
                }
            }
            else {
                logger.info("StackTraceElement is empty.");
            }
        }

        public void method1() {
            method2();
        }

        public void method2() {
            method3();
        }

        public void method3() {
            method4();
        }

        public void method4() {
            method5();
        }

        public void method5() {
            Thread.dumpStack();
        }
    }
}
