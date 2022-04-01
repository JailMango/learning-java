package core.basic.chapter09.命令模式;

import lombok.extern.slf4j.Slf4j;

/**
 * Receiver
 *
 * @author jailmango
 * @CreateDate 2020/12/17
 * @see core.basic.chapter09.命令模式
 * @since R9.0
 */
@Slf4j
public class Receiver {

    public void action(String command) {
        log.info("receive command, now execute command...");
    }
}
