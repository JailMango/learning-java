package com.jailmango.spring.application.accessor.impl;

import com.jailmango.spring.application.accessor.impl.base.AbstractFrequenceAccessor;
import com.jailmango.spring.application.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * FrequenceAccessor
 *
 * @author he.gang33
 * @CreateDate 2021/12/2
 * @see com.jailmango.spring.application.accessor
 */
@Component
@Slf4j
public class FrequenceAccessor extends AbstractFrequenceAccessor {

    @Autowired
    @Qualifier("customAccessRuleUtils")
    protected Utils accessRuleUtils;

    @Override
    protected void doCustomBiz() {
        log.info("entry doCustomBiz.");
    }

    @Override
    protected Utils utils() {
        return this.accessRuleUtils;
    }
}
