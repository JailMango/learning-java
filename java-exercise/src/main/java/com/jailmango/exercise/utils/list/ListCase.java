package com.jailmango.exercise.utils.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ListCase
 *
 * @author jailmango
 * @CreateDate 2019-03-20
 * @see com.jailmango.exercise.utils.list
 * @since R9.0
 */
public class ListCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ListCase.class);

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<ElementDto> list = new ArrayList<>(10);

        logger.info(String.valueOf(list.size()));

        List<String> strList = new ArrayList<>();
        list.add(null);
        list.add(null);

        logger.info(String.valueOf(list.size()));


        // 重要：会出现java.util.ConcurrentModificationException异常
        List<String> nameList = new ArrayList<>();
        nameList.add("1");
        nameList.add("2");
        nameList.add("3");
        nameList.add("4");
        nameList.add("5");

//        for (int i = nameList.size(); i > 0; i--) {
//            if (nameList.get(i - 1).equals("1")) {
//                nameList.remove(nameList.get(i - 1));
//            }
//            else if (nameList.get(i - 1).equals("2")) {
//                nameList.remove(nameList.get(i - 1));
//            }
//        }

//        会报错，不可以这么用
//        for (String name : nameList) {
//            if ("1".equals(name)) {
//                nameList.remove(name);
//            }
//            else if ("2".equals(name)) {
//                nameList.remove(name);
//            }
//        }

        Iterator<String> iterator = nameList.iterator();

        while (iterator.hasNext()) {
            String name = iterator.next();
            if ("1".equals(name)) {
                iterator.remove();
            }
            else if ("2".equals(name)) {
                iterator.remove();
            }
        }

        logger.info("====================================");

        List<ElementDto> srcList = Lists.newArrayList();
        List<ElementDto> destList = Lists.newArrayList();

        for (int i = 0; i < 5; i++) {
            ElementDto ele = new ElementDto();
            ele.setName(String.valueOf(i));
            ele.setSize(i);
            srcList.add(ele);
        }

        ElementDto tmp = null;
        ElementDto ele = null;
        for (int i = 0; i < srcList.size(); i++) {
            ele = srcList.get(i);

            tmp = new ElementDto();
            tmp.setSize(ele.getSize());
            tmp.setName(ele.getName());

            destList.add(tmp);
        }



        logger.info("end...");
    }
}

class ElementDto {

    private String name;

    private int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
