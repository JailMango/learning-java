package core.basic.chapter02;

import java.io.Serializable;

/**
 * 序列化对象
 *
 * @author jailmango
 * @CreateDate 2020/11/17
 * @see core.basic.chapter02
 * @since R9.0
 */
public class Data implements Serializable {

    // 序列化ID
    private static final long serialVersionUID = -3305611276366036514L;

    // 可以被序列化
    private int id;

    // 可以被序列化
    private String name;

    // transient修饰不会被序列化
    private transient int salary;

    // 静态变量属于类信息，不会被序列化
    private static int age = 100;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getAge() {
        return age;
    }

    public static void setAge(int age) {
        Data.age = age;
    }
}
