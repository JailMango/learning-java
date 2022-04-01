package com.jailmango.reflection.ifeve.chapter07;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.reflection.ifeve.dto.PersonDto;

/**
 * PrivateCase
 *
 * @author jailmango
 * @CreateDate 2019-04-18
 * @see com.jailmango.reflection.ifeve.chapter07
 * @since R9.0
 */
public class PrivateCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(PrivateCase.class);

    public static void main(String[] args)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = PersonDto.class;
        // 获取私有成员变量
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            /**
             * 通过调用setAccessible()方法会关闭指定类Field实例的反射访问检查 这行代码执行之后不论是私有的、受保护的以及包访问的作用域，你都可以在任何地方访问，即使你不在他的访问权限作用域之内。
             * 但是你如果你用一般代码来访问这些不在你权限作用域之内的代码依然是不可以的，在编译的时候就会报错
             */
            field.setAccessible(true);
            logger.info("Field Name: [{}], Field Type: [{}]", field.getName(), field.getType().getName());
        }

        // 获取私有方法，不会返回
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            logger.info("Method Name: [{}]", method.getName());
        }

        // 因为privateDo()是私有
        // Method privateDo = clazz.getMethod("privateDo", null);
        Method privateDo = clazz.getDeclaredMethod("privateDo", null);
        // 不设置访问权限为true，无法通过反射调用该private方法
        privateDo.setAccessible(true);
        // 调用私有方法
        PersonDto person = new PersonDto("HG", 25);
        String returnValue = (String) privateDo.invoke(person);
        logger.info("Return Value: [{}]", returnValue);



        logger.info("end...");
    }

}
