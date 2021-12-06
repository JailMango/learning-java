package com.jailmango.exercise.utils.string;

import com.google.common.base.CaseFormat;
import lombok.extern.slf4j.Slf4j;

/**
 * FormatCase
 *
 * @author he.gang33
 * @CreateDate 2020/7/17
 * @see com.jailmango.exercise.utils.string
 * @since R9.0
 */
@Slf4j
public class FormatCase {

    public static void main(String[] args) {
        String tmp = "%s = %s";

        System.out.println(String.format(tmp, "1", "2"));


        String result = CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "repeat_push_cargo_id");
        log.info(result);
    }
}
