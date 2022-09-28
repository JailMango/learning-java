package com.jailmango.exercise.utils.comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ComparatorCase
 *
 * @author jailmango
 * @CreateDate 2019-06-25
 * @see com.jailmango.exercise.utils.comparator
 * @since R9.0
 */
public class ComparatorCase {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ComparatorCase.class);

    public static void main(String[] args) {
        List<UserDto> list = new ArrayList<>(20);
        Random random = new Random();
        UserDto user = null;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 20; i++) {

            if (i % 3 != 0) {
                list.add(new UserDto());
                continue;
            }


            user = new UserDto(random.nextInt(100));
            list.add(user);

            sb.append(user.getAge()).append(", ");
        }

        logger.info("before sort: [{}]", sb.delete(sb.length() - 2, sb.length()));

        sb = new StringBuilder();

        list.sort(new UserComparator());

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).getAge()).append(", ");
        }

        String a = "v";

        logger.info("after sort: [{}]", sb.delete(sb.length() - 2, sb.length()));

        logger.info("end...");
    }
}
