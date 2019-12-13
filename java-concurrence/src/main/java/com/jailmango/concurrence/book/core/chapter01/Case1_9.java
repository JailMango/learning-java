package com.jailmango.concurrence.book.core.chapter01;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Case1_9
 *
 * @author he.gang33
 * @CreateDate 2019-05-21
 * @see com.jailmango.concurrence.book.core.chapter01
 * @since R9.0
 */
public class Case1_9 {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(Case1_9.class);

    public static void main(String[] args) {
        Case1_9 ins = new Case1_9();
        ins.a();
    }

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
        StringBuilder msg = new StringBuilder("\n");

        Map<Thread, StackTraceElement[]> map = Thread.getAllStackTraces();

        if (MapUtils.isNotEmpty(map)) {
            Set<Map.Entry<Thread, StackTraceElement[]>> entrySet = map.entrySet();
            Iterator<Map.Entry<Thread, StackTraceElement[]>> iterator = entrySet.iterator();

            while (iterator.hasNext()) {
                Map.Entry<Thread, StackTraceElement[]> entry = iterator.next();
                Thread thread = entry.getKey();
                StackTraceElement[] stackTraceElements = entry.getValue();

                msg.append("--- Thread Information --- \n");
                msg.append("    Thread ID: " + thread.getId() + " \n");
                msg.append("    Thread Name: " + thread.getName() + " \n");
                msg.append("    State: " + thread.getState() + " \n");
                msg.append("    StackTraceElement Length: " + stackTraceElements.length + " \n");

                if (0 != stackTraceElements.length) {
                    msg.append("    StackTraceElement[] Information \n");

                    for (int index = 0; index < stackTraceElements.length; index++) {
                        StackTraceElement stackTraceElement = stackTraceElements[index];
                        msg.append("        Class: [" + stackTraceElement.getClassName() + "], Method: ["
                            + stackTraceElement.getMethodName() + "], File: [" + stackTraceElement.getFileName()
                            + "], Line: [" + stackTraceElement.getLineNumber() + "] \n");
                    }
                }
            }
        }
        else {

        }

        logger.info(msg.toString());
    }

}
