package com.jailmango.reflection.ifeve.chapter08;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jailmango.reflection.ifeve.annotation.ReflectionAnnotation;
import com.jailmango.reflection.ifeve.dto.PersonDto;

/**
 * AnnotationCase
 *
 * @author he.gang33
 * @CreateDate 2019-04-19
 * @see com.jailmango.reflection.ifeve.chapter08
 * @since R9.0
 */
public class AnnotationCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(AnnotationCase.class);

    /**
     * main
     * 
     * @param args String[]
     * @throws NoSuchMethodException NoSuchMethodException
     * @throws NoSuchFieldException NoSuchFieldException
     */
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        // 类注解，获取所有注解
        Class clazz = PersonDto.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (Annotation annotation : annotations) {
            recordAnnotation(annotation);
        }

        // 类注解，获取指定类型注解
        Annotation annotation = clazz.getAnnotation(ReflectionAnnotation.class);
        recordAnnotation(annotation);

        // 方法注解
        Method method = clazz.getDeclaredMethod("annotationFunc", String.class, String.class, String.class);
        logger.info("Method: [{}]", method.getName());
        Annotation[] methodAnnotations = method.getAnnotations();
        for (Annotation methodAnnotation : methodAnnotations) {
            recordAnnotation(methodAnnotation);
        }

        // 参数注解
        Annotation[][] paramAnnotations = method.getParameterAnnotations();
        for (Annotation[] annotationsArr : paramAnnotations) {
            for (Annotation paramAnnotation : annotationsArr) {
                recordAnnotation(paramAnnotation);
            }
        }

        // 成员变量注解
        Field field = clazz.getDeclaredField("age");
        Annotation[] fieldAnnotations = field.getAnnotations();
        for (Annotation fieldAnnotation : fieldAnnotations) {
            recordAnnotation(fieldAnnotation);
        }
    }

    /**
     * recordAnnotation
     * 
     * @param annotation Annotation
     */
    private static void recordAnnotation(Annotation annotation) {
        logger.info("Annotation Name: [{}]", annotation.annotationType().getName());

        if (annotation instanceof ReflectionAnnotation) {
            ReflectionAnnotation reflectionAnnotation = (ReflectionAnnotation) annotation;
            logger.info("Annotation Value: [{}]", reflectionAnnotation.name());
        }
    }
}
