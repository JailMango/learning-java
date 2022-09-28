package com.jailmango.exercise.utils.model;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Result
 *
 * @author hegang1
 * @CreateDate 2022/6/21
 * @see com.jailmango.exercise.utils.model
 */
@Slf4j
public class Result extends Page {

    private List<String> list;

    Result(Long total, Long totalPage) {
        super(total, totalPage);
    }
}
