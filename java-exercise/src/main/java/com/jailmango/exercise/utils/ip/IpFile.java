package com.jailmango.exercise.utils.ip;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * IpFile
 *
 * @author hegang1
 * @CreateDate 2022/7/22
 * @see com.jailmango.exercise.utils.ip
 */
@Slf4j
public class IpFile {

    /**
     * main
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        List<Menu> list = Lists.newArrayList();

        list.add(Menu.builder().id(3).order(3).build());
        list.add(Menu.builder().id(1).order(1).build());
        list.add(Menu.builder().id(4).order(4).build());
        list.add(Menu.builder().id(2).order(2).build());



        list.add(Menu.builder().id(6).order(2).parentId(1).build());

        list.add(Menu.builder().id(11).order(3).parentId(2).build());
        list.add(Menu.builder().id(10).order(2).parentId(2).build());
        list.add(Menu.builder().id(5).order(1).parentId(1).build());

        list.add(Menu.builder().id(7).order(3).parentId(1).build());
        list.add(Menu.builder().id(8).order(4).parentId(1).build());
        list.add(Menu.builder().id(12).order(1).parentId(4).build());
        list.add(Menu.builder().id(9).order(1).parentId(2).build());




        List<Menu> result = Lists.newArrayList();



        result.sort(new MenuComparator());

        for (Menu menu : result) {
            // setChildren(menu, groupList);
        }

        log.info("{}", JSONObject.toJSONString(result));

        log.info("end...");
    }

    public static void setChildren(Menu parent, Map<Integer, List<Menu>> groups) {
        List<Menu> childrenList = groups.get(parent.getId());

        boolean isNotEmpty = Optional.ofNullable(childrenList).filter(Objects::nonNull).isPresent();

        if (!isNotEmpty) {
            return;
        }

        childrenList.stream().sorted(Comparator.comparingInt(Menu::getOrder));

        for (Menu menu : childrenList) {
            setChildren(menu, groups);
        }

        parent.setChildren(childrenList);
    }

    @Data
    @Builder
    private static class Menu {

        private Integer id;

        private Integer parentId;

        private Integer order;

        private List<Menu> children;
    }

    private static class MenuComparator implements Comparator<Menu> {

        @Override
        public int compare(Menu o1, Menu o2) {
            return o1.order - o2.order;
        }
    }
}
