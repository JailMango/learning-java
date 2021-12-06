package com.jailmango.spring.application.accessor.impl.base;

import com.jailmango.spring.application.accessor.Accessor;
import com.jailmango.spring.application.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * AbstractFrequenceAccessor
 *
 * @author he.gang33
 * @CreateDate 2021/12/2
 * @see com.jailmango.spring.application.accessor.base
 */
@Slf4j
public abstract class AbstractFrequenceAccessor implements Accessor {

    @Autowired
    @Qualifier("defaultAccessRuleUtils")
    protected Utils accessRuleUtils;

    @Override
    public void access() {
        doCommonBiz();
        doCustomBiz();
    }

    protected void doCommonBiz() {
        log.info("entry doCommonBiz.");
        utils().getAccessRule("");
    }

    protected abstract void doCustomBiz();

    protected Utils utils() {
        return this.accessRuleUtils;
    }
}
