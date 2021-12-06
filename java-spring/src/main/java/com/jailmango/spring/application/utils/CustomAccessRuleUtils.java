package com.jailmango.spring.application.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * AccessRuleUtils
 *
 * @author he.gang33
 * @CreateDate 2021/12/2
 * @see com.jailmango.spring.application.utils
 */
@Component("customAccessRuleUtils")
@Slf4j
public class CustomAccessRuleUtils implements Utils {

    @Override
    public String getAccessRule(String val) {
        log.info("entry custom getAccessRule.");

        return StringUtils.isBlank(val) ? "accessRule" : "customAccessRule";
    }
}
