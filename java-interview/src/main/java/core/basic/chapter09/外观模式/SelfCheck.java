package core.basic.chapter09.外观模式;

import lombok.extern.slf4j.Slf4j;

/**
 * SelfCheck
 *
 * @author jailmango
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.外观模式
 * @since R9.0
 */
@Slf4j
public class SelfCheck {

    public void startupCheck() {
        log.info("startup check finished...");
    }

    public void shutdownCheck() {
        log.info("shutdown check finished...");
    }
}
