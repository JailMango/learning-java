package com.jailmango.exercise.utils.lombok;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

/**
 * PushCargo
 *
 * @author jailmango
 * @CreateDate 2021/10/18
 * @see com.jailmango.exercise.utils.lombok
 */
@Data
@Builder
public class PushCargo {

    private Long cargoId;

    private String scene;

    private Long entryTime;

    private Long createTime;

    private String appType;

    private Double cargoScore;

    private Map<String, Object> scoreConditions;

    private Map<String, Object> content;
}
