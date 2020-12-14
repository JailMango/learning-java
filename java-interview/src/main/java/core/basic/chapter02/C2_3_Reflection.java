package core.basic.chapter02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;

/**
 * C2_3_反射
 *
 * @author he.gang33
 * @CreateDate 2020/11/16
 * @see core.basic.chapter02
 * @since R9.0
 */
@Slf4j
public class C2_3_Reflection {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException,
        InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 获取Person类的Class对象
        Class clazz = Class.forName("core.basic.chapter02.C2_3_Reflection$Person");
        // Class clazz = Class.forName("core.basic.chapter02.Person");

        // 获取Person类的所有方法的信息
        Method[] methods = clazz.getDeclaredMethods();

        // 获取Person类的所有属性
        Field[] fields = clazz.getDeclaredFields();

        // 获取Person类的所有构造函数
        Constructor[] constructors = clazz.getDeclaredConstructors();

        // 实例化对象
        Person person1 = (Person) clazz.newInstance();

        // 实例化对象
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
        Person person2 = (Person) constructor.newInstance("Mango", 20);

        // 调用方法 - invoke()
        Method methodSetName = clazz.getDeclaredMethod("setName", String.class);
        methodSetName.invoke(person1, "name-through-invoke");

        log.info("end...");
    }

    private static class Person {

        private String name;

        private int age;

        protected String protectedField;

        public String publicField;

        public Person() {

        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        protected void protectedMethod() {

        }

        private void privateMethod() {

        }
    }

}