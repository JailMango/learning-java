package com.jailmango.exercise.utils.operator;

/**
 * LogicalOperator
 *
 * @author he.gang33
 * @CreateDate 2020/9/14
 * @see com.jailmango.exercise.utils.operator
 * @since R9.0
 */
public class LogicalOperator {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        boolean a = true;
        boolean b = true;

        System.out.println("true && true : " + (a && b));
        System.out.println("true || true : " + (a || b));
        System.out.println("true ^ true : " + (a ^ b));

        boolean c = true;
        boolean d = false;

        System.out.println("true && false : " + (c && d));
        System.out.println("true || false : " + (c || d));
        System.out.println("true ^ false : " + (c ^ d));

        String attrValue = "2Mbps";
        String oldValue = "2Mbps/4Mbps";
        System.out.println("2Mbps ^ 2Mbps/4Mbps : " + (oldValue.indexOf("/") == -1 ^ attrValue.indexOf("/") == -1));

        oldValue = "2Mbps";
        attrValue = "2Mbps/4Mbps";
        System.out.println("2Mbps/4Mbps ^ 2Mbps : " + (oldValue.indexOf("/") == -1 ^ attrValue.indexOf("/") == -1));

        oldValue = "2Mbps";
        attrValue = "4Mbps";
        System.out.println("4Mbps ^ 2Mbps : " + (oldValue.indexOf("/") == -1 ^ attrValue.indexOf("/") == -1));

        oldValue = "4Mbps/2Mbps";
        attrValue = "2Mbps/4Mbps";
        System.out.println("4Mbps/2Mbps ^ 2Mbps/4Mbps : " + (oldValue.indexOf("/") == -1 ^ attrValue.indexOf("/") == -1));
    }
}
