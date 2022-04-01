package core.basic.chapter09.适配器模式.接口适配器模式;

import lombok.extern.slf4j.Slf4j;

/**
 * AbstractAdapter
 *
 * @author jailmango
 * @CreateDate 2020/12/13
 * @see core.basic.chapter09.适配器模式.接口适配器模式
 * @since R9.0
 */
@Slf4j
public class AbstractAdapter implements Sourceable {

    @Override
    public void editTextFile() {
        log.info("abstrace a text file editing...");
    }

    @Override
    public void editWordFile() {
        log.info("abstrace a word file editing...");
    }
}
