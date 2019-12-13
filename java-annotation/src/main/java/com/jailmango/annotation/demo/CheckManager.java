package com.jailmango.annotation.demo;

import java.lang.reflect.Method;

/**
 * CheckManager
 *
 * @author he.gang33
 * @CreateDate 2018/10/22
 * @see com.jailmango.java.annotation.demo
 * @since R9.0<br>
 */
public class CheckManager {

    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();
        TestCase testCase = new TestCase();
        Class clazz = testCase.getClass();
        Method[] methods = clazz.getMethods();
        int errNum = 0;

        for (Method method : methods) {
            if (method.isAnnotationPresent(Check.class)) {
                try {
                    method.setAccessible(true);
                    method.invoke(testCase, null);
                }
                catch (Exception e) {
                    errNum++;
                    log.append(method.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    // 记录测试过程中，发生的异常的名称
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    // 记录测试过程中，发生的异常的具体信息
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }

        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errNum);
        log.append(" error.");

        // 生成测试报告
        System.out.println(log.toString());
    }
}
