package com.jailmango.exercise.utils.json;

import lombok.Data;

/**
 * MonitorCookie
 *
 * @author hegang1
 * @CreateDate 2022/8/10
 * @see com.jailmango.exercise.utils.json
 */
@Data
public class MonitorCookie {
    private Boolean httpOnly;
    private Integer maxAge;
    private String name;
    private String path;
    private Boolean secure;
    private String value;
    private Integer version;
}
