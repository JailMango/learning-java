package com.jailmango.exercise.utils.list;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ListCase1
 *
 * @author hegang1
 * @CreateDate 2022/9/1
 * @see com.jailmango.exercise.utils.list
 */
@Slf4j
public class ListCase1 {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<String> a = Lists.newArrayList("a", "b", "c");
        List<String> b = Lists.newArrayList("b", "c", "d");

        List<String> result1 = getAddAndDeleteListForString(a, b);
        log.info("result1: {}", result1);

        List<String> result2 = getAddAndDeleteListForString(b, a);
        log.info("result2: {}", result2);


        List<Integer> c = Lists.newArrayList();
        for (int i = 0; i < 50; i++) {
                c.add(i);
        }

        log.info("result3: {}", c);

        int pageNum = 3;
        int pageSize = 10;
        List<Integer> result3 = c.subList(pageSize * pageNum, pageSize * (pageNum + 1));
        log.info("result3: {}", result3);
    }

    public static List<String> getAddAndDeleteListForString(List<String> newList, List<String> existedMenuIdList) {
        return existedMenuIdList.stream().filter(s -> !newList.contains(s)).collect(Collectors.toList());
    }
}
