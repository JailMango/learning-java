package com.jailmango.spring.application.accessor.impl.base;

import com.jailmango.spring.application.accessor.Accessor;
import com.jailmango.spring.application.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * AbstractFrequenceAccessor
 *
 * @author jailmango
 * @CreateDate 2021/12/2
 * @see com.jailmango.spring.application.accessor.base
 */
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
        // log.info("entry doCommonBiz.");
        System.out.println("entry doCommonBiz.");
        utils().getAccessRule("");
    }

    protected abstract void doCustomBiz();

    protected Utils utils() {
        return this.accessRuleUtils;
    }

    private boolean calculate(int num) {
        // log.info("do calculate.");
        System.out.println("do calculate.");
        return num % 2 == 0;
    }
}
