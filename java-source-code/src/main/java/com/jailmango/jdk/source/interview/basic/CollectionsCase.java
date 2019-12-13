package com.jailmango.jdk.source.interview.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * CollectionsCase
 *
 * @author he.gang33
 * @CreateDate 2019/11/5
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public class CollectionsCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(CollectionsCase.class);

    public static void main(String[] args) {

    }

    /**
     * Collections操作 - 排序、最大值、最小值
     */
    private static void operation() {
        List<SortDto> list = new ArrayList<>(4);
        list.add(new SortDto("300"));
        list.add(new SortDto("50"));
        list.add(new SortDto("220"));
        list.add(new SortDto("200"));
        // SortDto实现了Comparable接口，本身支持排序
        // 排序
        Collections.sort(list);
        // 最大值最小值
        SortDto maxSort = Collections.max(list);
        SortDto minSort = Collections.min(list);

        List<PersonDto> personList = new ArrayList<>(4);
        personList.add(new PersonDto("300"));
        personList.add(new PersonDto("50"));
        personList.add(new PersonDto("220"));
        personList.add(new PersonDto("200"));
        // 由于PersonDto没有实现Comparable接口，本身不支持排序，因此不可以使用下面方法对列表进行排序
        // 排序
        // Collections.sort(personList);
        Collections.sort(personList, Comparator.comparing(PersonDto::getName));
        // 最大值最小值
        PersonDto maxPerson = Collections.max(personList, Comparator.comparing(PersonDto::getName));
        PersonDto minPerson = Collections.min(personList, new PersonDtoComparator());

        logger.info("end...");
    }

    private static void synchronizedCollection() {
        List<PersonDto> personList = new ArrayList<>(4);
        personList.add(new PersonDto("300"));
        personList.add(new PersonDto("50"));
        personList.add(new PersonDto("220"));
        personList.add(new PersonDto("200"));

        List<PersonDto> list = Collections.synchronizedList(personList);
    }

}
