package core.basic.chapter09.外观模式;

import lombok.extern.slf4j.Slf4j;

/**
 * DashBoard
 *
 * @author jailmango
 * @CreateDate 2020/12/14
 * @see core.basic.chapter09.外观模式
 * @since R9.0
 */
@Slf4j
public class DashBoard {

    public void startup() {
        log.info("dashboard startup...");
    }

    public void shutdown() {
        log.info("dashboard shutdown...");
    }
}
