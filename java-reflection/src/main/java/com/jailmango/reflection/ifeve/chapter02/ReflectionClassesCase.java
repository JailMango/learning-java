package com.jailmango.reflection.ifeve.chapter02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.reflection.ifeve.dto.PersonDto;

/**
 * ReflectionClassesCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-17
 * @see com.jailmango.reflection.ifeve.chapter02
 * @since R9.0
 */
public class ReflectionClassesCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ReflectionClassesCase.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws ClassNotFoundException ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // 获取Class对象，第二种方式需要使用全类名
        Class class1 = PersonDto.class;
        Class class2 = Class.forName("com.jailmango.reflection.ifeve.dto.PersonDto");

        // 获取类名
        String class1Name = class1.getName();
        String class2Name = class2.getSimpleName();
        logger.info("Full Class Name: [{}]", class1Name);
        logger.info("Simple Class Name: [{}]", class2Name);

        // 获取类修饰符
        int modifiers = class1.getModifiers();
        checkModifiers(modifiers);

        // 获取包信息
        Package classPackage = class1.getPackage();
        logger.info("Package Name: [{}]", classPackage.getName());

        // 获取父类
        Class superClass = class1.getSuperclass();
        logger.info("Super Class: [{}]", superClass.getName());

        // 获取实现接口，不会返回父类实现的接口
        Class[] interfaces = class1.getInterfaces();
        for (Class interfaceClass : interfaces) {
            logger.info("Interface Name: [{}]", interfaceClass.getName());
        }

        // 获取构造函数
        Constructor[] constructors = class1.getConstructors();
        logger.info("Constructor Size: [{}]", constructors.length);

        // 获取方法
        Method[] methods = class1.getMethods();
        for (Method method : methods) {
            logger.info("Method Name: [{}]", method.getName());
        }

        // 获取成员变量, 只能获取到public, 无法获取继承自父类的属性及私有private属性
        Field[] fields = class1.getFields();
        for (Field field : fields) {
            logger.info("Field Name: [{}], Class: [{}]", field.getName(), field.getType().getName());
        }

        // 获取注解
        Annotation[] annotations = class1.getAnnotations();
        for (Annotation annotation : annotations) {
            logger.info("Annotation Name: [{}]", annotation.annotationType().getName());
        }

    }

    /**
     * 判断修饰符
     * 
     * @param modifiers int
     */
    private static void checkModifiers(int modifiers) {
        if (Modifier.isAbstract(modifiers)) {
            logger.info("Modifier: [{}]", "abstract");
        }
        else if (Modifier.isFinal(modifiers)) {
            logger.info("Modifier: [{}]", "final");
        }
        else if (Modifier.isInterface(modifiers)) {
            logger.info("Modifier: [{}]", "interface");
        }
        else if (Modifier.isNative(modifiers)) {
            logger.info("Modifier: [{}]", "native");
        }
        else if (Modifier.isPrivate(modifiers)) {
            logger.info("Modifier: [{}]", "private");
        }
        else if (Modifier.isProtected(modifiers)) {
            logger.info("Modifier: [{}]", "protected");
        }
        else if (Modifier.isPublic(modifiers)) {
            logger.info("Modifier: [{}]", "public");
        }
        else if (Modifier.isStatic(modifiers)) {
            logger.info("Modifier: [{}]", "static");
        }
        else if (Modifier.isStrict(modifiers)) {
            logger.info("Modifier: [{}]", "strict");
        }
        else if (Modifier.isSynchronized(modifiers)) {
            logger.info("Modifier: [{}]", "synchronized");
        }
        else if (Modifier.isTransient(modifiers)) {
            logger.info("Modifier: [{}]", "transient");
        }
        else if (Modifier.isVolatile(modifiers)) {
            logger.info("Modifier: [{}]", "volatile");
        }
    }
}
