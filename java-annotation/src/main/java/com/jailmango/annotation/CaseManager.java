package com.jailmango.annotation;

/**
 * CaseManager
 *
 * @author jailmango
 * @CreateDate 2018/10/22
 * @see com.jailmango.java.annotation
 * @since R9.0<br>
 */
public class CaseManager {

    public static void main(String[] args) {
        boolean hasAnnotation = MsgIns.class.isAnnotationPresent(Message.class);

        if (hasAnnotation) {
            Message msgAnnotation = MsgIns.class.getAnnotation(Message.class);
            System.out.println("[ID]: [" + msgAnnotation.id() + "], [Messge]: [" + msgAnnotation.msg() + "]");
        }
    }
}
