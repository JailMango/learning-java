package core.basic.chapter09.装饰者模式;

import lombok.extern.slf4j.Slf4j;

/**
 * Source
 *
 * @author he.gang33
 * @CreateDate 2020/12/13
 * @see core.basic.chapter09.装饰者模式
 * @since R9.0
 */
@Slf4j
public class Source implements Sourceable {

    @Override
    public void createComputer() {
        log.info("create computer by source...");
    }
}
