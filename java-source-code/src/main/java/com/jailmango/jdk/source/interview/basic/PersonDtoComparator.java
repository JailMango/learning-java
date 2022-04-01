package com.jailmango.jdk.source.interview.basic;

import java.util.Comparator;

/**
 * PersonDtoComparator
 *
 * @author jailmango
 * @CreateDate 2019/11/5
 * @see com.jailmango.jdk.source.interview.basic
 * @since R9.0
 */
public class PersonDtoComparator implements Comparator<PersonDto> {

    @Override
    public int compare(PersonDto o1, PersonDto o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
