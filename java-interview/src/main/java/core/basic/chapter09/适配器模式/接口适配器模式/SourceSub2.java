package core.basic.chapter09.适配器模式.接口适配器模式;

import lombok.extern.slf4j.Slf4j;

/**
 * SourceSub2
 *
 * @author jailmango
 * @CreateDate 2020/12/13
 * @see core.basic.chapter09.适配器模式.接口适配器模式
 * @since R9.0
 */
@Slf4j
public class SourceSub2 extends AbstractAdapter {

    @Override
    public void editWordFile() {
        log.info("a word file editing...");
    }
}
