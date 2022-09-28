package com.jailmango.exercise.utils.model;

import lombok.Builder;
import lombok.Data;

/**
 * Person
 *
 * @author hegang1
 * @CreateDate 2022/6/21
 * @see com.jailmango.exercise.utils.model
 */
@Data
@Builder
public class Person {

    private Long id;

    private String name;
}
