package com.jailmango.exercise.utils.comparator;

import java.util.Comparator;

/**
 * UserComparator
 *
 * @author he.gang33
 * @CreateDate 2019-06-25
 * @see com.jailmango.exercise.utils.comparator
 * @since R9.0
 */
public class UserComparator implements Comparator<UserDto> {

    @Override
    public int compare(UserDto o1, UserDto o2) {
        return o1.getAge() - o2.getAge();
    }
}
