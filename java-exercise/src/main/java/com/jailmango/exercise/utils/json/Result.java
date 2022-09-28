package com.jailmango.exercise.utils.json;

import lombok.Data;

/**
 * Result
 *
 * @author hegang1
 * @CreateDate 2022/8/10
 * @see com.jailmango.exercise.utils.json
 */
@Data
public class Result<T> {

    private T data;
}
