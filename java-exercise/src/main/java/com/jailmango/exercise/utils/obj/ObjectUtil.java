package com.jailmango.exercise.utils.obj;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * ObjectUtil
 *
 * @author he.gang33
 * @CreateDate 2020/4/20
 * @see com.jailmango.exercise.utils.obj
 * @since R9.0
 */
public final class ObjectUtil {

    public static void main(String[] args) {
        List<Person> balList = new ArrayList<>();
        balList.add(new Person(1L, "P-1"));
        balList.add(new Person(2L, "P-2"));
        balList.add(new Person(3L, "P-3"));

        Map<String, Object> src = new HashMap<>();
        src.put("spId", 0L);
        src.put("userName", "86156");
        src.put("effDate", new Date());
        src.put("balList", balList);

        Map<String, Object> dest = toUpperCaseAndUnderline(src);

        int a = 1;
    }

    public static Map<String, Object> toUpperCaseAndUnderline(Map<String, Object> src) {
        Map<String, Object> dest = new HashMap<>();

        Iterator<Map.Entry<String, Object>> it = src.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            dest.put(toUpperCaseAndUnderline(entry.getKey()), entry.getValue());
        }

        return dest;
    }

    private static String toUpperCaseAndUnderline(String key) {
        StringBuffer sbf = new StringBuffer();
        int begin = 0;

        for (int index = 0; index < key.length(); index++) {
            if (Character.isUpperCase(key.charAt(index))) {
                if (begin < index) {
                    sbf.append(key.substring(begin, index).toUpperCase()).append("_");
                }
                begin = index;
            }
        }

        sbf.append(key.substring(begin).toUpperCase());

        return sbf.toString();
    }
}

class Person {

    private Long id;

    private String name;

    public Person(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
