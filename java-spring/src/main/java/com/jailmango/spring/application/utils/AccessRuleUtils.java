package com.jailmango.spring.application.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * AccessRuleUtils
 *
 * @author jailmango
 * @CreateDate 2021/12/2
 * @see com.jailmango.spring.application.utils
 */
@Component("defaultAccessRuleUtils")
@Slf4j
public class AccessRuleUtils implements Utils {

    @Override
    public String getAccessRule(String val) {
        log.info("entry getAccessRule.");

        return StringUtils.isBlank(val) ? "accessRule" : "customAccessRule";
    }
}
