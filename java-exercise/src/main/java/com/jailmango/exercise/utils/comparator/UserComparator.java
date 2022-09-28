package com.jailmango.exercise.utils.comparator;

import java.util.Comparator;
import java.util.Objects;

/**
 * UserComparator
 *
 * @author jailmango
 * @CreateDate 2019-06-25
 * @see com.jailmango.exercise.utils.comparator
 * @since R9.0
 */
public class UserComparator implements Comparator<UserDto> {

    @Override
    public int compare(UserDto o1, UserDto o2) {
        if (Objects.isNull(o1) || Objects.isNull(o1.getAge())) {
            return 1;
        }

        if (Objects.isNull(o2) || Objects.isNull(o2.getAge())) {
            return -1;
        }

        return o2.getAge() - o1.getAge();
    }
}
