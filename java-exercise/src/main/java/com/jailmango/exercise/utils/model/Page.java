package com.jailmango.exercise.utils.model;

import lombok.Builder;
import lombok.Data;

/**
 * Page
 *
 * @author hegang1
 * @CreateDate 2022/6/21
 * @see com.jailmango.exercise.utils.model
 */
@Data
@Builder
public class Page {

    private Long total = 0L;

    private Long totalPage = 0L;
}
